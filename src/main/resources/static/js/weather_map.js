//
// // ***** WEATHER CARD DATA FUNCTION *****
// function weatherCardData(lng, lat) {
//     // CREATES AN EMPTY HTML STRING
//     let htmlCity = "";
//     let htmlFeels = "";
//     let htmlWind = "";
//     // OPEN WEATHER GET REQUEST WITH lat AND lng REFERENCING weatherCardData FUNCTION PARAMETERS
//     $.get("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lng + "&appid=" + WEATHER_MAP_KEY, {
//         units: "imperial"
//     // RETRIEVES DATA(weatherData) FROM GET REQUEST
//     }).done(function (weatherData) {
//
//
//         $('#cityName').html("<h1 style='color: #0fb784'>" + "Today's weather in " + weatherData.city.name + "</h1>");
//         //
//         // const submitForm = document.getElementById("data-form");
//         //
//         // // CREATING SUBMIT FORM INSIDE HTML WEATHER-CARD ELEMENT.
//         //
//         // const citySelectTag = document.createElement("select")
//         // submitForm.appendChild(citySelectTag);
//         //
//         //
//         // const feelsSelectTag = document.createElement("select")
//         // submitForm.appendChild(feelsSelectTag);
//         //
//         // const windSpeedSelectTag = document.createElement("select")
//         // submitForm.appendChild(windSpeedSelectTag);
//
//
//         //
//         //     for (let i = 0; i <= 39; i += 8) {
//
//                 // const cityOption = document.createElement("option");
//                 // console.log(weatherData);
//                 // cityOption.value = weatherData.city.name;
//                 // cityOption.text = weatherData.city.name;
//                 // citySelectTag.appendChild(cityOption);
//
//                 //         const cityData = document.getElementById("weatherCity")
//                 //         cityData.value = weatherData.city.name;
//                 //         cityData.text = weatherData.city.name;
//                 //
//                 //     }
//                 //
//                 // weatherData.list.forEach(option => {
//                 //     // const feelsOption = document.createElement("option");
//                 //     // console.log(option);
//                 //     // feelsOption.value = option.main.feels_like;
//                 //     // feelsOption.text = option.main.feels_like;
//                 //     // feelsSelectTag.appendChild(feelsOption);
//                 //
//                 //     const feelsLikeOption = document.getElementById("feelsLike")
//                 //     feelsLikeOption.value = option.main.feels_like;
//                 //     feelsLikeOption.text = option.main.feels_like;
//                 // })
//                 //
//                 // weatherData.list.forEach(option => {
//                 //     // const windSpeedOption = document.createElement("option");
//                 //     // console.log(option);
//                 //     // windSpeedOption.value = option.wind.speed;
//                 //     // windSpeedOption.text = option.wind.speed;
//                 //     // windSpeedSelectTag.appendChild(windSpeedOption);
//                 //
//                 //     const windSpeedOption = document.getElementById("windSpeed")
//                 //     windSpeedOption.value = option.wind.speed;
//                 //     windSpeedOption.text = option.wind.speed;
//                 // })
//
//         for (let i = 0; i <= 39; i += 8) {
//             console.log("line 70: " + weatherData.city.name);
//
//             htmlCity += `
//                 <html lang="en" xmlns:th="http://www.thymeleaf.org">
//
// <!--            html += "<label for='weatherCitySelect'> Choose a City:</label>"-->
//
// <!--            html += "<select name='weatherCitySelect' id='weatherCitySelect'>"-->
//              <option name='weatherCity' id='weatherCity' th:field='*{location}' value='${weatherData.city.name}' text='${weatherData.city.name}'>${weatherData.city.name}</option>
// <!--            html += "</select>"-->
//
//             <button type='submit'>Submit</button>
//              </form>
//                 </html>`
//         }
//                 $('#weatherCitySelect').html(htmlCity);
//
//
//         weatherData.list.forEach(option => {
//             htmlFeels += `
//             <html lang="en" xmlns:th="http://www.thymeleaf.org">
//             <option name="feelsLike" id="feelsLike" th:field='*{feelsLike}' value=${option.main.feels_like}' text='${option.main.feels_like}'>${option.main.feels_like}</option>
//            </html> `
//         })
//
//         $('#feelsLikeSelect').html(htmlFeels);
//
//         weatherData.list.forEach(option => {
//
//             htmlWind += `
//
//             <html lang="en" xmlns:th="http://www.thymeleaf.org">
//             <option name="windSpeed" id="windSpeed" th:field="*{windSpeed}" value='${option.wind.speed}' text='${option.wind.speed}'>${option.wind.speed}</option>
//               </html>  `
//         })
//
//         $('#windSpeedSelect').html(htmlWind);
//
//
//
//
//
//     })
//
//
//
//
//     // html += "<label for='feelsLikeSelect'>Choose a Feels Like:</label>"
//     //
//     // html += "<select name='feelsLikeSelect' id='feelsLikeSelect'>"
//     // html += "<option name='feelsLike' id='feelsLike' th:field='*{feelsLike}' value='${weatherData.list[i].main.feels_like}' text='${weatherData.list[i].main.feels_like}'>${weatherData.list[i].main.feels_like}</option>"
//     // html += "</select>"
//     //
//     //
//     //
//     //
//     // html += "<label for='windSpeedSelect'>Choose a Wind Speed:</label>"
//     //
//     // html += "<select name='windSpeedSelect' id='windSpeedSelect'>"
//     // html += "<option name='windSpeed' id='windSpeed' th:field='*{windSpeed}' value='${weatherData.list[i].wind.speed}' text='${weatherData.list[i].wind.speed}'>${weatherData.list[i].wind.speed}</option>"
//     // html += "</select>"
// }
//
//
//
