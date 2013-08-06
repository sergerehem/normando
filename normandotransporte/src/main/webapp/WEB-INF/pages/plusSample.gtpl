<!--
  Copyright (c) 2011 Google Inc.

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy of
  the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations under
  the License.

  To run this sample, replace YOUR API KEY with your application's API key.
  It can be found at https://code.google.com/apis/console/?api=plus under API Access.
-->
<!DOCTYPE html>
<html>
  <head>
    <meta charset='utf-8' />
    <style>
      #info {
        border: 1px solid black;
        padding: 0.25em;
      }
    </style>
    <script>
      // Enter the API key from the Google Develoepr Console - to handle any unauthenticated
      // requests in the code.
      // The provided key works for this sample only when run from
      // https://google-api-javascript-client.googlecode.com/hg/samples/simpleRequest.html
      // To use in your own application, replace this API key with your own.
      var apiKey = 'AIzaSyAgKx_3UQiZljWm0Kab0rFbdKVBixF3yuQ';

      function load() {
        gapi.client.setApiKey(apiKey);
        gapi.client.load('urlshortener', 'v1', showInputs);
      }

      function showInputs() {
        document.getElementById('requestFields').style.display = '';
      }

      function makeRequest() {
        function writeResponse(resp) {
          var responseText;
          if (resp.code && resp.data[0].debugInfo == 'QuotaState: BLOCKED') {
            responseText = 'Invalid API key provided. Please replace the "apiKey" value with your own.';
          } else {
            responseText = 'Short URL ' + shortUrl + ' expands to ' + resp.longUrl;
          }
          var infoDiv = document.getElementById('info');
          infoDiv.innerHTML = '';
          infoDiv.appendChild(document.createTextNode(responseText));
        }

        var shortUrl = document.getElementById('shortUrl').value;
        var request = gapi.client.urlshortener.url.get({
          'shortUrl': shortUrl
        });
        request.execute(writeResponse);
      }
    </script>
    <script src="https://apis.google.com/js/client.js?onload=load"></script>
  </head>
  <body>
    <p>Enter a short URL and click "Expand URL" to get the full URL.</p>
    <div id="requestFields" style="display:none;">
      <label for="shortUrl">Short URL </label>
      <input id="shortUrl" type="text" value="http://goo.gl/fbsS" />
      <button onclick="makeRequest();">
        Expand URL
      </button>
    </div>
    <div style="margin-top:0.5em;"><span id="info">Results</span></div>
  </body>
</html>
Hide details
Change log
dd7bef9f2787 by Brendan O'Brien <obr...@google.com> on Dec 2, 2011   Diff
Cleaning up code samples.

1. Replace body onload with recommended
?onload param at the end of the JS Client
script URL.
2. Remove usage of innerHTML (except to
clear elements).
3. Provide default API key that will work
on the code site (but nowhere else).
Go to: 	
Older revisions
 e8723de37ddf by chir...@google.com on Dec 1, 2011   Diff 
 bba07571fb41 by Brendan O'Brien <obr...@google.com> on Oct 21, 2011   Diff 
 6a9fc147aeec by Brendan O'Brien <obr...@google.com> on Oct 20, 2011   Diff 
All revisions of this file
File info
Size: 2893 bytes, 79 lines
View raw file

