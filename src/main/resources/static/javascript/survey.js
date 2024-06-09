function nextStep(currentStep) {
    var currentDiv = document.getElementById("step" + currentStep);
    var nextDiv = document.getElementById("step" + (currentStep + 1));

    var radio = currentDiv.querySelectorAll('input[type="radio"]');
    var numberInputs = currentDiv.querySelectorAll('input[type="number"]')
    var isValid = false;
    radio.forEach(function(radio){
        if (radio.checked) {
            isValid = true;
        }
    });

    numberInputs.forEach(function (input){
        if (input.value == ""){
            isValid = false;
        }
    });

    if (isValid && nextDiv) {
        currentDiv.style.display = "none";
        nextDiv.style.display = "flex";
    }
}

document.getElementById("survey").addEventListener("submit", function(event) {
    event.preventDefault();

    var formData = new FormData(event.target);

    var headers = new Headers();
    headers.append('X-CSRF-TOKEN', document.querySelector('input[name="_csrf"]').value);

    fetch("/survey", {
        method: "POST",
        headers: headers,
        body: formData
    })
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('Network response was not ok.');
            }
        })
        .then(result => {
            console.log('Success:', result);
            // Check if the response indicates a duplicate key error
            if (result.includes('homepage')) {
                console.log("duplicate error happend")
            } else {
                window.location.href = "/login";
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
});
function lastStep(step) {
    var currentStep = document.getElementById("step" + step);
    var lastStep = document.getElementById("step" + (step - 1));
    if (lastStep) {
        currentStep.style.display = "none";
        lastStep.style.display = "flex";
    }
}