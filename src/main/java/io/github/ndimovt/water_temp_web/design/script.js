const images = ["image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg", "image5.jpg", "image6.jpg"];
const body = document.body;
let currentIndex = 0;

function changeBackground(){
    body.style.backgroundImage = `url('images/${images[currentIndex]}')`;
    currentIndex = (currentIndex + 1) % images.length;
}

setInterval(changeBackground, 60000);

function logIn(){
    window.open("log.html","", "width=500,height=500");
}

function byYear(){
    window.open("byYear.html", "", "width=500, height=500");
}

function byDateTown(){
    window.open("dateTown.html","", "width=500,height=500");
}

function scientistEntry(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("pass").value;
    fetch(`http://localhost:8081/info/get/${encodeURIComponent(username)}/${encodeURIComponent(password)}`,{
        method: 'GET',
        mode: 'cors',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => response.json())
            .then(data => {
                let obj = {
                    username: data.username,
                    password: data.password,
                    name: data.name,
                    surname: data.surname
                };
                if(username == obj.username && password == obj.password){
                window.open(`sci-index.html?name=${encodeURIComponent(obj.name)}&surname=${encodeURIComponent(obj.surname)}`);
                }else{
                    alert("Wrong username or password");
                }
            })
}
