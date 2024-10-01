let timeInterval;

document.body.addEventListener('click', function() {
    document.body.style.backgroundColor ='lavender'
});

document.getElementById('timeButton').addEventListener('click', function() {
    if (!timeInterval) {
        timeInterval = setInterval(function() {
            const timeDisplay = document.getElementById('timeDisplay');
            timeDisplay.textContent = new Date().toLocaleTimeString();
        }, 1000);
    }
});

// Change text on hover
document.getElementById('hoverText').addEventListener('mouseover', function() {
    this.textContent = 'Nice try!';
});

document.getElementById('hoverText').addEventListener('mouseout', function() {
    this.textContent = 'Hello... try to touch me!';
});
