# Connection_Pooling.

This is very simple Spring boot based rest template connection pooling example. 
Used HttpClient for creating rest template. Also, used one 'third party free consumption service' for calling and verification purpose.

2 rest template beans got created--one is default & another is pooled one. Beans got differentiated by name. 

All implemented services are `GET` services; so that we can use curl for testing behaviour.

Security aspect-
This project is mutual auth based i.e. for calling webservice, we need to use ssl certificate.
For consuming this service, we can use simple curl with passing certificate within it.

Typical certificate generation have been achieved via below steps:



#server cert	
`keytool -genkeypair -dname "CN=localhost, OU=IT, O=TEST, L=PUNE , ST=MH, C=IN" -alias serverkey -keyalg RSA -keypass password -keystore caservercertdev.jks -storepass password -validity 730`

#client cert
`keytool -genkeypair -dname "CN=api.devmiluma.lumapr.com, OU=IT, O=TEST, L=PUNE , ST=MH, C=IN" -alias clientkey -keyalg RSA -keypass password -keystore caclientcertdev.jks -storepass password -validity 730`


#export client cert to client.cer
`keytool -exportcert -rfc -alias clientkey -file client.cer -keypass password -keystore caclientcertdev.jks -storepass password`

#add client.cer to server keystore
`keytool -importcert -alias clientkey -file client.cer -keystore caservercertdev.jks -storepass password -noprompt`


#export server cert to server.cer
`keytool -exportcert -rfc -alias serverkey -file server.cer -keypass password -keystore caservercertdev.jks -storepass password`

#add server.cer to client keystore
`keytool -importcert -alias serverkey -file server.cer -keystore caclientcertdev.jks -storepass password -noprompt`


