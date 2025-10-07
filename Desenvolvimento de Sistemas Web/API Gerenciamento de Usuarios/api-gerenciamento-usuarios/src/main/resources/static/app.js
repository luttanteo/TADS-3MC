// Configuração da URL base da API
const apiUrl = 'http://localhost:8081/api/usuarios';
const uploadUrl = 'http://localhost:8081/api/arquivos/upload';

// Capturando elementos do DOM que serão utilizados frequentemente
const form = document.getElementById('formulario-usuario');
const tabelaCorpo = document.getElementById('tabela-usuarios-corpo');
const campoId = document.getElementById('usuario-id');
const campoNome = document.getElementById('nome');
const campoApelido = document.getElementById('apelido');
const campoEmail = document.getElementById('email');
const campoDataNascimento = document.getElementById('dataNascimento');
const btnLimpar = document.getElementById('btn-limpar');

// Função para criar o elemento de imagem com fallback
function criarImagemPerfil(url) {
    const img = document.createElement('img');
    img.className = 'foto-perfil';
    img.alt = 'Foto de Perfil';
    img.style.width = '40px';
    img.style.height = '40px';
    img.style.objectFit = 'cover';
    img.style.borderRadius = '50%';
    img.onerror = () => img.src = 'placeholder.png';
    img.src = url || 'placeholder.png';
    return img;
}

// Função para carregar e exibir os usuários na tabela
async function carregarUsuarios() {
    try {
        const response = await fetch(apiUrl);
        if (!response.ok) {
            throw new Error('Erro ao buscar usuários');
        }
        const usuarios = await response.json();

        tabelaCorpo.innerHTML = '';
        usuarios.forEach(usuario => {
            const tr = document.createElement('tr');

            // Célula da foto
            const tdFoto = document.createElement('td');
            tdFoto.className = 'foto-container';

            // Adiciona a imagem
            tdFoto.appendChild(criarImagemPerfil(usuario.caminhoFotoPerfil));

            // Adiciona o formulário de upload
            const uploadForm = document.createElement('form');
            uploadForm.className = 'form-upload mt-2';
            uploadForm.dataset.usuarioId = usuario.id;
            uploadForm.innerHTML = `
                <div class="input-group input-group-sm">
                    <input type="file" name="arquivo" class="form-control" accept="image/*" required>
                    <button type="submit" class="btn btn-outline-primary">Enviar</button>
                </div>
            `;
            tdFoto.appendChild(uploadForm);
            tr.appendChild(tdFoto);

            // Adiciona as outras informações
            tr.innerHTML += `
                <td>${usuario.id}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.apelido}</td>
                <td>${usuario.email}</td>
                <td>
                    <button class="btn btn-sm btn-warning btn-editar" data-id="${usuario.id}">Editar</button>
                    <button class="btn btn-sm btn-danger btn-deletar" data-id="${usuario.id}">Deletar</button>
                </td>
            `;

            tabelaCorpo.appendChild(tr);
        });
    } catch (error) {
        console.error('Erro:', error);
        alert('Não foi possível carregar os usuários');
    }
}

// Função para limpar o formulário
function limparFormulario() {
    form.reset();
    campoId.value = '';
}

// Função para salvar um usuário
async function salvarUsuario(event) {
    event.preventDefault();

    const usuario = {
        nome: campoNome.value,
        apelido: campoApelido.value,
        email: campoEmail.value,
        dataNascimento: campoDataNascimento.value
    };

    const id = campoId.value;

    try {
        const response = await fetch(
            id ? `${apiUrl}/${id}` : apiUrl,
            {
                method: id ? 'PUT' : 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(usuario)
            }
        );

        if (!response.ok) {
            throw new Error('Erro ao salvar usuário');
        }

        limparFormulario();
        carregarUsuarios();
        alert('Usuário salvo com sucesso!');
    } catch (error) {
        alert('Erro ao salvar usuário: ' + error.message);
    }
}

// Função para fazer upload de foto
async function uploadFoto(event) {
    event.preventDefault();

    const form = event.target;
    const usuarioId = form.dataset.usuarioId;
    const fileInput = form.querySelector('input[type="file"]');
    const submitButton = form.querySelector('button[type="submit"]');
    const arquivo = fileInput.files[0];

    if (!arquivo) {
        alert('Selecione uma foto');
        return;
    }

    if (arquivo.size > 5 * 1024 * 1024) {
        alert('O arquivo é muito grande. O tamanho máximo é 5MB.');
        return;
    }

    try {
        submitButton.disabled = true;
        submitButton.textContent = 'Enviando...';

        const formData = new FormData();
        formData.append('arquivo', arquivo);

        const response = await fetch(`${uploadUrl}/${usuarioId}`, {
            method: 'POST',
            body: formData
        });

        const responseText = await response.text();

        if (!response.ok) {
            throw new Error(responseText || 'Erro ao enviar a foto');
        }

        alert('Foto enviada com sucesso!');
        await carregarUsuarios();
    } catch (error) {
        console.error('Erro no upload:', error);
        alert(error.message || 'Erro ao enviar a foto');
    } finally {
        submitButton.disabled = false;
        submitButton.textContent = 'Enviar';
        form.reset();
    }
}

// Função para deletar um usuário
async function deletarUsuario(id) {
    if (!confirm('Tem certeza que deseja deletar este usuário?')) {
        return;
    }

    try {
        const response = await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
        if (!response.ok) {
            throw new Error('Erro ao deletar usuário');
        }
        carregarUsuarios();
        alert('Usuário deletado com sucesso!');
    } catch (error) {
        alert(error.message);
    }
}

// Função para carregar dados para edição
async function carregarParaEdicao(id) {
    try {
        const response = await fetch(`${apiUrl}/${id}`);
        if (!response.ok) {
            throw new Error('Erro ao carregar dados do usuário');
        }
        const usuario = await response.json();

        campoId.value = usuario.id;
        campoNome.value = usuario.nome;
        campoApelido.value = usuario.apelido;
        campoEmail.value = usuario.email;
        campoDataNascimento.value = usuario.dataNascimento;
    } catch (error) {
        alert(error.message);
    }
}

// Event Listeners
document.addEventListener('DOMContentLoaded', carregarUsuarios);
form.addEventListener('submit', salvarUsuario);
btnLimpar.addEventListener('click', limparFormulario);

// Delegação de eventos para a tabela
tabelaCorpo.addEventListener('click', event => {
    const target = event.target;
    if (target.classList.contains('btn-deletar')) {
        deletarUsuario(target.dataset.id);
    } else if (target.classList.contains('btn-editar')) {
        carregarParaEdicao(target.dataset.id);
    }
});

// Delegação de eventos para formulários de upload
document.addEventListener('submit', event => {
    if (event.target.classList.contains('form-upload')) {
        uploadFoto(event);
    }
});
