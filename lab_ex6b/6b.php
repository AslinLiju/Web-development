<?php
// Load the XML file
$xml = simplexml_load_file("animals.xml") or die("Error: Cannot create object");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animal Data</title>
    <link rel="stylesheet" href="6b.css"> <!-- Link to external CSS file -->
</head>
<body>

    <div class="container">
        <h1>Animal Information</h1>

        <?php
        foreach ($xml->Animal as $animal) {
            $breed = $animal->Breed;
            $lifeExpectancy = $animal->LifeExpectancy;
            $price = $animal->Price;
            $dateAdded = $animal->DateAdded;
        ?>

            <div class="animal-info">
                <p><strong>Breed:</strong> <?php echo $breed; ?></p>
                <p><strong>Life Expectancy:</strong> <?php echo $lifeExpectancy; ?></p>
                <p><strong>Price:</strong> $<?php echo $price; ?></p>
                <p><strong>Date Added:</strong> <?php echo $dateAdded; ?></p>
            </div>

        <?php
        }
        ?>

    </div>

</body>
</html>
