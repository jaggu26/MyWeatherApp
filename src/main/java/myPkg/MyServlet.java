package myPkg;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		try {

			String city = request.getParameter("citynew");
			String APIKey = "23c678db64c454c722192f6fbdcc1482\r\n" + "";
			String APIUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + APIKey + "";
			URL url = new URL(APIUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			InputStream inputStream = connection.getInputStream();

			InputStreamReader reader = new InputStreamReader(inputStream);
			StringBuilder responseContent = new StringBuilder();
			java.util.Scanner scanner = new java.util.Scanner(reader);

			while (scanner.hasNext()) {
				responseContent.append(scanner.nextLine());
			}
			scanner.close();

			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);

			long dateTimeStamp = jsonObject.get("dt").getAsLong() * 1000;
			Date date = new Date(dateTimeStamp);
			double tempKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
			int tempCelsius = (int) (tempKelvin - 273.15);
			int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
			double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
			String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main")
					.getAsString();

			request.setAttribute("date", date);
			request.setAttribute("city", city);
			request.setAttribute("temperature", tempCelsius);
			request.setAttribute("weatherCondition", weatherCondition);
			request.setAttribute("humidity", humidity);
			request.setAttribute("windSpeed", windSpeed);
			request.setAttribute("weatherData", responseContent.toString());

			connection.disconnect();
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
