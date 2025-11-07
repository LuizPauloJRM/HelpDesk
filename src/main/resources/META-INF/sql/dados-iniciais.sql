
-- SCRIPT DE DADOS INICIAIS - SISTEMA HELPDESK
-- Autor: Luiz Paulo
-- Descrição: Cria dados base para clientes, técnicos, usuários e chamados



-- TABELA PERFIL (controle de permissões)

INSERT INTO perfil (id, nome) VALUES
(1, 'ADMIN'),
(2, 'TECNICO'),
(3, 'CLIENTE');


-- TABELA USUARIO (login e autenticação)

INSERT INTO usuario (id, nome, email, senha, perfil_id) VALUES
(1, 'Administrador', 'admin@helpdesk.com', 'admin123', 1),
(2, 'Ana Paula', 'ana.tecnico@helpdesk.com', '1234', 2),
(3, 'Roberto Dias', 'roberto.tecnico@helpdesk.com', '1234', 2),
(4, 'João Silva', 'joao.cliente@helpdesk.com', '1234', 3),
(5, 'Maria Souza', 'maria.cliente@helpdesk.com', '1234', 3);


-- TABELA TECNICO

INSERT INTO tecnico (id, nome, email, especialidade, usuario_id) VALUES
(1, 'Ana Paula', 'ana.tecnico@helpdesk.com', 'Redes e Infraestrutura', 2),
(2, 'Roberto Dias', 'roberto.tecnico@helpdesk.com', 'Software e Sistemas', 3);


-- TABELA CLIENTE

INSERT INTO cliente (id, nome, email, telefone, usuario_id) VALUES
(1, 'João Silva', 'joao.cliente@helpdesk.com', '11987654321', 4),
(2, 'Maria Souza', 'maria.cliente@helpdesk.com', '21988887777', 5);


-- TABELA CHAMADO

INSERT INTO chamado (id, titulo, descricao, data_abertura, data_fechamento, prioridade, status, cliente_id, tecnico_id) VALUES
(1, 'Erro ao abrir o sistema', 
    'Cliente relata que o sistema trava ao abrir o painel principal.',
    NOW(), NULL, 'ALTA', 'ABERTO', 1, 1),

(2, 'Sem acesso à internet', 
    'Cliente informa que não tem conexão desde ontem.',
    NOW(), NULL, 'MEDIA', 'EM_ANDAMENTO', 2, 2),

(3, 'Problemas com login',
    'Cliente esqueceu a senha e não consegue redefinir pelo sistema.',
    NOW(), NULL, 'BAIXA', 'ABERTO', 1, NULL),

(4, 'Erro no módulo financeiro',
    'Ao tentar emitir relatório, o sistema exibe erro SQL.',
    NOW(), NULL, 'ALTA', 'ABERTO', 2, 1);


-- RELACIONAMENTOS ADICIONAIS (se houver)
-- Exemplo: se houver tabela intermediária cliente_chamado, tecnico_chamado etc.
-- (adicione aqui conforme suas entidades evoluírem)
