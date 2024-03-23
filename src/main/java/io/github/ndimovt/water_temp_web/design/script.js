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

function today(){
    window.open("today.html", "", "width=500, height=500");
}

function byDateTown(){
    window.open("dateTown.html","", "width=700, height=700");
}

function scientistEntry(){

    document.getElementById('scientistLog').addEventListener('submit', function(e) {
        e.preventDefault();


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
            .catch(error => alert('Connection error. Please contact your local IT support!' + error))
        });
}

function checkTodayTemp(){
    document.getElementById('form').addEventListener('submit', function(e) {
        e.preventDefault();

        let selectedTown;
        const townRadios = document.getElementsByName('town');
        townRadios.forEach(radio => {
            if (radio.checked) {
                selectedTown = radio.value;
            }
        });
        const currentDate = new Date();
        let year = currentDate.getFullYear();
        let month = currentDate.getMonth() + 1;
        let day = currentDate.getDate();
        let today = `${year}-${month < 10? '0' + month : month}-${day < 10? '0' + day : day}`;

        fetch(`http://localhost:8081/year/${encodeURIComponent(selectedTown)}/${encodeURIComponent(today)}`,{
            method: 'GET',
            mode: 'cors',
            headers: {
                'Accept' : 'application/json'
            }
        })
        .then(res => {
            if(!res.ok){
                alert('Connection failed!');
            }else{
                return res.json()
            }
        })
        .then(data => {
            if(data == 0.0){
                alert('Information is not available yet! Please try again later!');
            }else{
                alert(`Temperature in ${selectedTown} is ${data} degrees`);
            }
        });
    });
}

const xDates = [];
const yTemp = [];

function getGraphData(){
    document.getElementById('form').addEventListener('submit', function(e) {
        e.preventDefault();

        let town;
        const radioTown = document.getElementsByName('towns');
        radioTown.forEach(radio => {
            if(radio.checked){
                town = radio.value;
            }
        });
        let date = document.getElementById('date').value;

        fetch(`http://localhost:8081/byTownDate/${town}/${date}`, {
            method: 'GET',
            mode: 'cors',
            headers:{
                'Accept' : 'application/json'
            }
        })
            .then(res => {
                if(!res.ok){
                    alert('Connection failed!')
                }else{
                    return res.json()
                }
            })
            .then(data => {
                data.forEach(item => {
                    xDates.push(item.date);
                    yTemp.push(item.temperature);
                });
                createGraph(town);
            })
            .catch(error => console.log(error))
        })
}

function createGraph(town){
    getGraphData();
    console.log(xDates);
    console.log(yTemp);

    trace1 = {
        x: xDates,
        y: yTemp,
        mode: 'lines+markers',
        name: 'Red',
        line: {
          color: 'rgb(219, 64, 82)',
          width: 3
        }
      };

      var layout = {
        title: `${town}`,
        width: 500,
        height: 500,
    };

      var data = [trace1];

      Plotly.newPlot('myDiv', data, layout);
}

function home(){
    window.open('index.html');
}

function insertSingleRecord(){
    window.open('single-record.html','', 'width=500, height=500');
}

function readFile(){
    const userFile = document.getElementById('file').files[0];

    const formData = new FormData();
    formData.append('file', userFile);

    fetch('http://localhost:8081/table', {
        method: 'POST',
        body: formData,
    })
    .then(res => res.json())
    .then(data => {
        if(data == 201)
        alert('Database updated successfully!')
        else if(data == 409)
        alert('Information already exists in database!')
    })
    .catch(error => alert('Connection error. Please contact your local IT support!'))
}

function insertSingle(){
    document.getElementById('insertForm').addEventListener('submit', function(e){
        e.preventDefault();

        let town;
        const choice = document.getElementsByName('town');
        choice.forEach(radio => {
            if(radio.checked){
                town = radio.value;
            }
        });

        let temperature = document.getElementById('temperature').value;
        let date = document.getElementById('date').value;

        const information = {
            town: town,
            temperature: temperature,
            date: date
        };

        fetch('http://localhost:8081/insert', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(information)
        })
        .then(response => response.json())
        .then(data => {
            if(data == true){
                alert('Information successfully inserted in database!');
            }else{
                alert('Record already exists in database!');
            }
        })
        .catch(error => console.log(error));
    });
}