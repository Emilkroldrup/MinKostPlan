// For at tilføje et input felt når man trykker på plus

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


// For at tilføje et billede med "Tilføj billede" knappen

document.getElementById('fileInput').addEventListener('change', function(event) {
    var file = event.target.files[0];
    var reader = new FileReader();

    reader.onload = function(e) {
        var img = document.getElementById('previewImage');
        img.src = e.target.result;
        img.style.display = 'block';
    };

    reader.readAsDataURL(file);
});