// Script principal para o menu
// As funções específicas de cada exercício estão em suas respectivas páginas

// Função para adicionar efeitos visuais aos botões do menu
document.addEventListener('DOMContentLoaded', function() {
    let botoes = document.querySelectorAll('.menu-buttons button');
    
    botoes.forEach(function(botao) {
        botao.addEventListener('mouseenter', function() {
            this.style.transform = 'scale(1.05)';
        });
        
        botao.addEventListener('mouseleave', function() {
            this.style.transform = 'scale(1)';
        });
    });
});

