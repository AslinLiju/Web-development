const breeds = {
    dog: [
        'Labrador', 'Jack Russel Terrier', 'Dachshund', 'Pomeranian',
        'Yorkshire Terrier', 'Maltese', 'Chihuahua', 'Corgi',
        'Miniature Pinscher', 'King Charles Spaniel'
    ],
    cat: [
        'Siamese', 'Persian', 'Snowshoe', 'Sokoke',
        'Laperm', 'Munchkin', 'Oriental Shorthair', 'Abyssinian'
    ],
    bird: [
        'Parrot', 'Canary', 'Finch', 'Parakeet',
        'Chicken', 'Love bird'
    ],
    fish: [
        'Angel Fish', 'Red Tailed Black Shark', 'Discus', 'Guppy',
        'Goldfish', 'Tiger Barb', 'Lionhead Cichlid', 'Neon Tetra',
        'Labidochromis Caeruleus'
    ],
    rabbit: [
        'Netherland Dwarf', 'Jersey Wooly', 'Holland Lop',
        'Mini Rex', 'Dutch', 'Mini Lop', 'Rex', 'Satin',
        'New Zealand', 'French Lop'
    ]
};

function updateBreedOptions() {
    const speciesInput = document.getElementById('species').value.toLowerCase();
    const breedSelect = document.getElementById('breed');
    breedSelect.innerHTML = '<option value="">Select Breed</option>';
    if (breeds[speciesInput]) {
        breeds[speciesInput].forEach(breed => {
            const option = document.createElement('option');
            option.value = breed;
            option.textContent = breed;
            breedSelect.appendChild(option);
        });
    } else {
        breedSelect.innerHTML = '<option value="">No breeds available for this species</option>';
    }
}

function validateForm() {
    let isValid = true;
    const name = document.getElementById('petName').value.trim();
    const species = document.getElementById('species').value;
    const breed = document.getElementById('breed').value;
    const color = document.getElementById('color').value.trim();
    const sex = document.getElementById('sex').value;
    const birthday = document.getElementById('birthday').value;
    const adoptionDay = document.getElementById('adoptionDay').value;
    const weight = document.getElementById('weight').value;

    document.getElementById('nameError').textContent = '';
    document.getElementById('speciesError').textContent = '';
    document.getElementById('breedError').textContent = '';
    document.getElementById('colorError').textContent = '';
    document.getElementById('sexError').textContent = '';
    document.getElementById('birthdayError').textContent = '';
    document.getElementById('adoptionDayError').textContent = '';
    document.getElementById('weightError').textContent = '';
    document.getElementById('formMessage').textContent = '';

    if (name === '') {
        document.getElementById('nameError').textContent = 'Name is required';
        isValid = false;
    }
    if (species === '') {
        document.getElementById('speciesError').textContent = 'Species is required';
        isValid = false;
    }
    if (breed === '') {
        document.getElementById('breedError').textContent = 'Breed is required';
        isValid = false;
    }
    if (color === '') {
        document.getElementById('colorError').textContent = 'Color is required';
        isValid = false;
    }
    if (sex === '') {
        document.getElementById('sexError').textContent = 'Sex is required';
        isValid = false;
    }
    if (birthday === '') {
        document.getElementById('birthdayError').textContent = 'Birthday is required';
        isValid = false;
    }
    if (adoptionDay === '') {
        document.getElementById('adoptionDayError').textContent = 'Adoption day is required';
        isValid = false;
    }
    if (weight === '' || isNaN(weight) || weight <= 0) {
        document.getElementById('weightError').textContent = 'Valid weight is required';
        isValid = false;
    }
    if (isValid) {
        document.getElementById('formMessage').textContent = 'Form submitted successfully!';
    }
}

