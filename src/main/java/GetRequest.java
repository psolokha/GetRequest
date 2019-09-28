import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRequest {

    private static String sURL = "http://speller.yandex.net/services/spellservice";

    public static void main(String... agrs) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(sURL + "/checkTexts?text=Цган&text=на+ципочках&text=седит&text=циц&text=ципленку&text=говарит");

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            System.out.println("\nResponse status :");
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            System.out.println("\nResult :");
            System.out.println(EntityUtils.toString(entity));

            EntityUtils.consume(entity);

            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
