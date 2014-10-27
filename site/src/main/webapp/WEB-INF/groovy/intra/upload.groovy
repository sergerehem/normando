def blobs = blobstore.getUploadedBlobs(request)
def blob = blobs["myTextFile"]
 
response.status = 302
 
if (blob) {
redirect "/intranet/success?key=${blob.keyString}"
} else {
redirect "/intranet/failure"
}

