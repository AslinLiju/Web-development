<?php
$servername = "localhost"; 
$username = "root"; 
$password = "";
$database = "pets"; 

$conn = new mysqli($servername, $username, $password, $database);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$animalType = '';
$result = null;

if ($_SERVER["REQUEST_METHOD"] === "POST" && isset($_POST['type'])) {
    $animalType = $conn->real_escape_string($_POST['type']); 
    $sql = "SELECT breed_name, life_expectancy, price FROM Animals WHERE type='$animalType'";
    $result = $conn->query($sql);
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animal Information</title>
    <link rel="stylesheet" href="6a.css"> 
</head>
<body>
    <div class="container">
        <h1>Animal Information</h1>

        <form method="POST" action="">
            <label for="type">Select an animal type:</label>
            <select name="type" id="type" required>
                <option value="">--Choose Type--</option>
                <option value="Dog" <?php if ($animalType === 'Dog') echo 'selected'; ?>>Dog</option>
                <option value="Cat" <?php if ($animalType === 'Cat') echo 'selected'; ?>>Cat</option>
                <option value="Bird" <?php if ($animalType === 'Bird') echo 'selected'; ?>>Bird</option>
                <option value="Fish" <?php if ($animalType === 'Fish') echo 'selected'; ?>>Fish</option>
                <option value="Rabbit" <?php if ($animalType === 'Rabbit') echo 'selected'; ?>>Rabbit</option>
            </select>
            <button type="submit">Show Details</button>
        </form>

        <?php
        if ($_SERVER["REQUEST_METHOD"] === "POST" && !empty($animalType)) {
            if ($result && $result->num_rows > 0) {
                echo "<h2>Details of $animalType Breeds</h2>";
                while ($row = $result->fetch_assoc()) {
                    $breed = $row['breed_name'];
                    $lifeExpectancy = $row['life_expectancy'];
                    $price = $row['price'];
        ?>

            <div class="animal-info">
                <p><strong>Breed:</strong> <?php echo htmlspecialchars($breed); ?></p>
                <p><strong>Life Expectancy:</strong> <?php echo htmlspecialchars($lifeExpectancy); ?></p>
                <p><strong>Price:</strong> $<?php echo number_format($price, 2); ?></p>
            </div>
        <?php
                }
            } else {
                echo "<p>No animals found for the selected type.</p>";
            }
        } elseif ($_SERVER["REQUEST_METHOD"] === "POST") {
            echo "<p>Please select an animal type.</p>";
        }

        $conn->close();
        ?>
    </div>
</body>
</html>
