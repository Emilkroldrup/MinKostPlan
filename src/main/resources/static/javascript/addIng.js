document.addEventListener('DOMContentLoaded', function() {
    var addButton = document.querySelector('.addIngredient');
    var ingredientSection = document.querySelector('.ingredient');

    addButton.addEventListener('click', function() {
        var input = document.createElement('input');
        input.type = 'text';
        input.placeholder = 'Indtast ingrediens...';

        var button = document.createElement('button');
        button.textContent = 'Godkend';

        var container = document.createElement('div');
        container.appendChild(input);
        container.appendChild(button);

        container.classList.add('addIng');

        ingredientSection.appendChild(container);
    });
});