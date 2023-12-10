<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Weather Report</title>
    <!-- Include Weather Icons library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/weather-icons/2.0.12/css/weather-icons.min.css">

    <style>
        body {
            background-color: #87CEEB; /* Sky Blue */
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            color: #2F4F4F; /* Dark Slate Gray */
            font-family: 'Arial', sans-serif;
        }

        h1 {
            font-size: 32px;
            margin-bottom: 20px;
            color: #2E8B57; /* Sea Green */
        }

        p {
            font-size: 18px;
            margin-bottom: 10px;
            color: #2F4F4F; /* Dark Slate Gray */
        }

        /* Custom styling for icons */
        .wi {
            font-size: 24px;
            margin-right: 5px;
            color: #2F4F4F; /* Dark Slate Gray */
        }

        label {
            display: inline-block;
            font-size: 18px;
            margin-bottom: 5px;
            color: #008080; /* Teal */
        }

        /* Custom styling for spans around dynamic content */
        .dynamic-content {
            color: #333; /* Dark Gray */
        }

        /* Different colors for labels and their respective data */
        .label-date { color: #800080; } /* Purple */
        .label-city { color: #008000; } /* Green */
        .label-temperature { color: #FF4500; } /* Orange Red */
        .label-weather { color: #000080; } /* Navy */
        .label-humidity { color: #FF8C00; } /* Dark Orange */
        .label-wind { color: #4682B4; } /* Steel Blue */

        /* Styling for the Home button */
        .home-button {
            position: absolute;
            top: 10px;
            left: 10px;
            padding: 10px;
            font-size: 16px;
            background-color: #008000; /* Green */
            color: #FFF; /* White */
            text-decoration: none;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .home-button:hover {
            background-color: #006400; /* Dark Green */
        }
    </style>
</head>
<body>
    <a href="index.html" class="home-button">Home</a>
    <h1>Weather Report</h1>
    <div>
        <p><label class="label-date">Date:</label> <span class="dynamic-content">${date}</span></p>
        <p><label class="label-city">City:</label> <span class="dynamic-content">${city}</span></p>
        <p><label class="label-temperature">Temperature:</label> <span class="dynamic-content">${temperature} <i class="wi wi-thermometer"></i></span></p>
        <p><label class="label-weather">Weather Condition:</label> <span class="dynamic-content">${weatherCondition} <i class="wi wi-day-sunny"></i></span></p>
        <p><label class="label-humidity">Humidity:</label> <span class="dynamic-content">${humidity} <i class="wi wi-humidity"></i></span></p>
        <p><label class="label-wind">Wind Speed:</label> <span class="dynamic-content">${windSpeed} <i class="wi wi-strong-wind"></i></span></p>
    </div>
</body>
</html>
