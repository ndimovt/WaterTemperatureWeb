const images = ["image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg", "image5.jpg", "image6.jpg"];
const body = document.body;
let currentIndex = 0;

function changeBackground(){
    body.style.backgroundImage = `url('images/${images[currentIndex]}')`;
    currentIndex = (currentIndex + 1) % images.length;
}

setInterval(changeBackground, 60000);

