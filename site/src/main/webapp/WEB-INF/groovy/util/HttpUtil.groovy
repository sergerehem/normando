package util

public class HttpUtil {
		
	static def getBodyPart(request, part) {
		String bodyPart = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				request.getInputStream()));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = reader.readLine()) != null;) {
			if (line.endsWith("name=\"$part\"")) {
				reader.readLine();
				bodyPart = reader.readLine();
			}
		}
		return bodyPart
	}
}

