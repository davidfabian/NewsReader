package com.example.d.newsreader;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by d on 9/22/2017.
 */

public class QueryUtils {
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private static final String JSON_TEST_STRING_1 = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":3129,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":313,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"business/2017/jul/16/workers-rights-need-more-protection-in-the-gig-economy\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2017-07-16T16:37:34Z\",\"webTitle\":\"Workers’ rights need more protection in the gig economy | Letters\",\"webUrl\":\"https://www.theguardian.com/business/2017/jul/16/workers-rights-need-more-protection-in-the-gig-economy\",\"apiUrl\":\"https://content.guardianapis.com/business/2017/jul/16/workers-rights-need-more-protection-in-the-gig-economy\",\"isHosted\":false},{\"id\":\"politics/2017/sep/07/immigration-and-the-uks-post-brexit-economy\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2017-09-07T17:39:54Z\",\"webTitle\":\"Immigration and the UK’s post-Brexit economy | Letters\",\"webUrl\":\"https://www.theguardian.com/politics/2017/sep/07/immigration-and-the-uks-post-brexit-economy\",\"apiUrl\":\"https://content.guardianapis.com/politics/2017/sep/07/immigration-and-the-uks-post-brexit-economy\",\"isHosted\":false},{\"id\":\"commentisfree/2017/jun/03/britain-broken-desperately-need-new-ideas-general-election\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2017-06-03T23:03:07Z\",\"webTitle\":\"Britain’s economy is broken. We desperately need new ideas | Tom Kibasi\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2017/jun/03/britain-broken-desperately-need-new-ideas-general-election\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2017/jun/03/britain-broken-desperately-need-new-ideas-general-election\",\"isHosted\":false},{\"id\":\"money/2017/may/26/how-older-workers-can-help-the-economy\",\"type\":\"article\",\"sectionId\":\"money\",\"sectionName\":\"Money\",\"webPublicationDate\":\"2017-05-26T17:41:21Z\",\"webTitle\":\"How older workers can help the economy | Letters\",\"webUrl\":\"https://www.theguardian.com/money/2017/may/26/how-older-workers-can-help-the-economy\",\"apiUrl\":\"https://content.guardianapis.com/money/2017/may/26/how-older-workers-can-help-the-economy\",\"isHosted\":false},{\"id\":\"commentisfree/2017/sep/06/britain-control-immigration-debate-nasty-politics-social-neglect-brexit\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2017-09-06T18:26:52Z\",\"webTitle\":\"Britain can control immigration. What drives this debate is nasty politics | Simon Jenkins\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2017/sep/06/britain-control-immigration-debate-nasty-politics-social-neglect-brexit\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2017/sep/06/britain-control-immigration-debate-nasty-politics-social-neglect-brexit\",\"isHosted\":false},{\"id\":\"business/2017/aug/23/brexit-economy-guardian-eu-exit-talks\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2017-08-23T09:31:31Z\",\"webTitle\":\"Brexit economy: outlook positive but rocky negotiations could bring instability\",\"webUrl\":\"https://www.theguardian.com/business/2017/aug/23/brexit-economy-guardian-eu-exit-talks\",\"apiUrl\":\"https://content.guardianapis.com/business/2017/aug/23/brexit-economy-guardian-eu-exit-talks\",\"isHosted\":false},{\"id\":\"commentisfree/2017/jun/02/economy-confusing-jargon-my-charity-clear-communication-informed-voters\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2017-06-02T12:44:49Z\",\"webTitle\":\"The economy is crucial to the election. So why all the confusing jargon? | Victoria Waldersee\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2017/jun/02/economy-confusing-jargon-my-charity-clear-communication-informed-voters\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2017/jun/02/economy-confusing-jargon-my-charity-clear-communication-informed-voters\",\"isHosted\":false},{\"id\":\"politics/2017/jun/22/markets-brexit-watch-bank-of-england-interest-rate\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2017-06-22T11:01:42Z\",\"webTitle\":\"'Markets don’t like chaos' – experts debate Brexit watch data\",\"webUrl\":\"https://www.theguardian.com/politics/2017/jun/22/markets-brexit-watch-bank-of-england-interest-rate\",\"apiUrl\":\"https://content.guardianapis.com/politics/2017/jun/22/markets-brexit-watch-bank-of-england-interest-rate\",\"isHosted\":false},{\"id\":\"business/2017/aug/23/growth-uk-brexit-data-consumer-squeeze\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2017-08-23T09:31:45Z\",\"webTitle\":\"'Growth is slowing in the UK, but picking up elsewhere' – experts debate Brexit data\",\"webUrl\":\"https://www.theguardian.com/business/2017/aug/23/growth-uk-brexit-data-consumer-squeeze\",\"apiUrl\":\"https://content.guardianapis.com/business/2017/aug/23/growth-uk-brexit-data-consumer-squeeze\",\"isHosted\":false},{\"id\":\"business/2017/feb/22/economy-slowing-brexit-watch-data\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2017-02-22T10:42:36Z\",\"webTitle\":\"'The economy looks set to be slowing again' – experts debate Brexit watch data\",\"webUrl\":\"https://www.theguardian.com/business/2017/feb/22/economy-slowing-brexit-watch-data\",\"apiUrl\":\"https://content.guardianapis.com/business/2017/feb/22/economy-slowing-brexit-watch-data\",\"isHosted\":false}]}}";
    private static final String JSON_TEST_STRING_2 = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":20,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":2,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"politics/2017/aug/23/how-has-the-brexit-vote-affected-the-uk-economy-august-verdict\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2017-08-23T09:31:49Z\",\"webTitle\":\"How has the Brexit vote affected the UK economy? August verdict\",\"webUrl\":\"https://www.theguardian.com/politics/2017/aug/23/how-has-the-brexit-vote-affected-the-uk-economy-august-verdict\",\"apiUrl\":\"https://content.guardianapis.com/politics/2017/aug/23/how-has-the-brexit-vote-affected-the-uk-economy-august-verdict\",\"isHosted\":false},{\"id\":\"news/2017/jun/03/the-big-issue-labour-manifesto-what-economy-needs\",\"type\":\"article\",\"sectionId\":\"news\",\"sectionName\":\"News\",\"webPublicationDate\":\"2017-06-03T23:05:08Z\",\"webTitle\":\"Labour’s manifesto proposals could be just what the economy needs | The big issue\",\"webUrl\":\"https://www.theguardian.com/news/2017/jun/03/the-big-issue-labour-manifesto-what-economy-needs\",\"apiUrl\":\"https://content.guardianapis.com/news/2017/jun/03/the-big-issue-labour-manifesto-what-economy-needs\",\"isHosted\":false},{\"id\":\"commentisfree/2017/jan/23/brexit-banking-local-regional-jobs\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2017-01-23T14:00:19Z\",\"webTitle\":\"The UK’s economy is London-centric. Brexit is the chance to change that | Laurie Macfarlane\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2017/jan/23/brexit-banking-local-regional-jobs\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2017/jan/23/brexit-banking-local-regional-jobs\",\"isHosted\":false},{\"id\":\"inequality/2017/sep/15/europes-food-apartheid-are-brands-in-the-east-lower-quality-than-in-the-west\",\"type\":\"article\",\"sectionId\":\"inequality\",\"sectionName\":\"Inequality\",\"webPublicationDate\":\"2017-09-15T16:00:47Z\",\"webTitle\":\"Europe's 'food apartheid': are brands in the east lower quality than in the west?\",\"webUrl\":\"https://www.theguardian.com/inequality/2017/sep/15/europes-food-apartheid-are-brands-in-the-east-lower-quality-than-in-the-west\",\"apiUrl\":\"https://content.guardianapis.com/inequality/2017/sep/15/europes-food-apartheid-are-brands-in-the-east-lower-quality-than-in-the-west\",\"isHosted\":false},{\"id\":\"world/2017/jun/20/two-thirds-europeans-believe-eu-hard-line-brexit-poll\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2017-06-19T23:01:48Z\",\"webTitle\":\"Two-thirds of Europeans believe EU should take hard line on Brexit – poll\",\"webUrl\":\"https://www.theguardian.com/world/2017/jun/20/two-thirds-europeans-believe-eu-hard-line-brexit-poll\",\"apiUrl\":\"https://content.guardianapis.com/world/2017/jun/20/two-thirds-europeans-believe-eu-hard-line-brexit-poll\",\"isHosted\":false},{\"id\":\"world/2017/aug/24/net-migration-to-uk-drops-to-lowest-level-for-three-years\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2017-08-24T10:50:09Z\",\"webTitle\":\"Net migration to UK drops to lowest level for three years\",\"webUrl\":\"https://www.theguardian.com/world/2017/aug/24/net-migration-to-uk-drops-to-lowest-level-for-three-years\",\"apiUrl\":\"https://content.guardianapis.com/world/2017/aug/24/net-migration-to-uk-drops-to-lowest-level-for-three-years\",\"isHosted\":false},{\"id\":\"travel/2017/jun/16/uk-tourists-pound-brexit-us-holiday-exchange-rates\",\"type\":\"article\",\"sectionId\":\"travel\",\"sectionName\":\"Travel\",\"webPublicationDate\":\"2017-06-16T11:47:05Z\",\"webTitle\":\"UK attracts record overseas tourists after pound's Brexit slide\",\"webUrl\":\"https://www.theguardian.com/travel/2017/jun/16/uk-tourists-pound-brexit-us-holiday-exchange-rates\",\"apiUrl\":\"https://content.guardianapis.com/travel/2017/jun/16/uk-tourists-pound-brexit-us-holiday-exchange-rates\",\"isHosted\":false},{\"id\":\"commentisfree/2017/sep/09/do-we-have-will-to-reform-society-or-are-we-in-terminal-decline\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2017-09-09T23:05:21Z\",\"webTitle\":\"Like fading powers of the past, Britain shows signs of being in terminal decline  | Will Hutton\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2017/sep/09/do-we-have-will-to-reform-society-or-are-we-in-terminal-decline\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2017/sep/09/do-we-have-will-to-reform-society-or-are-we-in-terminal-decline\",\"isHosted\":false},{\"id\":\"commentisfree/2017/sep/12/the-guardian-view-on-the-european-union-sticking-together\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2017-09-12T18:38:51Z\",\"webTitle\":\"The Guardian view on the European Union: sticking together | Editorial\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2017/sep/12/the-guardian-view-on-the-european-union-sticking-together\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2017/sep/12/the-guardian-view-on-the-european-union-sticking-together\",\"isHosted\":false},{\"id\":\"commentisfree/2017/aug/05/brexit-uk-food-industry-eu-fruit-veg-pickers\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2017-08-05T05:59:04Z\",\"webTitle\":\"They say after Brexit there’ll be food rotting in the fields. It’s already started | John Harris\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2017/aug/05/brexit-uk-food-industry-eu-fruit-veg-pickers\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2017/aug/05/brexit-uk-food-industry-eu-fruit-veg-pickers\",\"isHosted\":false}]}}";
    private static final String GUARDIAN_URL = "http://content.guardianapis.com/search?q=trump&from-date=2017-01-01&section=us-news&order-by=newest&api-key=test";
    private static String JSONRESPONSE = "";

    //create url
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }

    //getting json response from website
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonresponse = "";
// If the URL is null, then return early.
        if (url == null) {
            Log.e(LOG_TAG, "url==null" + jsonresponse);
            return jsonresponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonresponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonresponse;
    }


    //helper method: builds JSon string from inputstream
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        JSONRESPONSE = output.toString();
        return JSONRESPONSE;
    }

    public static List<Article> extractArticles() {

        // create url
        // get response
        // parse response
        // return list.

        // create container
        List<Article> articles = new ArrayList<>();

        // create url
        URL url = createUrl(GUARDIAN_URL);
        try {
            JSONRESPONSE = makeHttpRequest(url);
        } catch (IOException io) {
            Log.e(LOG_TAG, "problem retrieving the article json results.", io);
        }

        //try parsing JSON string
        try {
            JSONObject articleList = new JSONObject(JSONRESPONSE);
            JSONObject response = articleList.getJSONObject("response");
            String status = response.getString("status");
            int total = response.getInt("total");
            JSONArray results = response.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject currentArticle = results.getJSONObject(i);
                String section = currentArticle.getString("sectionName");
                String title = currentArticle.getString("webTitle");
                String articleUrl = currentArticle.getString("webUrl");
                String articleDate = currentArticle.getString("webPublicationDate");

                articles.add(new Article(title, section, articleUrl, articleDate));
            }

        } catch (JSONException e) {
            Log.e("Queryutils, ", "Problem parsing JSON STRING");
        }


        Log.e("articlelist created, ", "length: " + articles.size());

        return articles;
    }
}
