// script.js

// Funzione per aggiungere il prodotto al carrello
//function aggiungiAlCarrello() {
    // Mostra un alert quando il pulsante "Aggiungi al Carrello" viene premuto
    //alert("Prodotto aggiunto al carrello!");
//}
function openNav() {
      document.getElementById("mySidebar").style.width = "250px"}

function closeNav() {
      document.getElementById("mySidebar").style.width = "0"}

function goToHomePage() {
        window.location.href = '/';
    }
// script.js

function aggiungiAlCarrello() {
    alert("Prodotto aggiunto al carrello!");
}

let slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  let i;
  const slides = document.getElementsByClassName("slide");
  const dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}
