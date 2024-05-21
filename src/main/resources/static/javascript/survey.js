function nextStep(currentStep) {
    var currentDiv = document.getElementById("step" + currentStep);
    var nextDiv = document.getElementById("step" + (currentStep + 1));
    if (nextDiv) {
        currentDiv.style.display = "none";
        nextDiv.style.display = "block";
    }
}

document.getElementById("surveyForm").addEventListener("submit", function(event) {
    event.preventDefault();

    var formData = new FormData(event.target);

    var headers = new Headers();
    headers.append('X-CSRF-TOKEN', document.querySelector('input[name="_csrf"]').value);

    fetch("/survey", {
        method: "POST",
        headers: headers,
        body: formData
    })
    .then(response => response.text())
    .then(result => {
        console.log('Success:', result);
        // redirect to the home page
        window.location.href = "/login";
    })
    .catch(error => {
        console.error('Error:', error);
    });
});