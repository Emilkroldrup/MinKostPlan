function loadNavbar(navbarId){
    console.log('Loading navbar...');
    fetch('navbar.html')
        .then((response) =>{
            if(!response.ok){
                throw new Error('Failed to load navbar');
            }
            return response.text();
        })
        .then((html) =>{
            const navbarElement = document.getElementById(navbarId);
            if (navbarElement){
                navbarElement.innerHTML = html;
                console.log('Navbar loaded successfully!');
            } else{
                console.warn(`Element with ID '${navbarId}' not found.`);
            }
        })
        .catch((error) => console.error('Error loading navbar:', error));
}