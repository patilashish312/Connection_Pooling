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
keytool -genkeypair -dname "cn=localhost, ou=MyOu, o=Ashish PC, c=UK" -alias serverKey -keyalg RSA -keypass password -keystore caservercert.jks -storepass password -validity 1000

#client cert
keytool -genkeypair -dname "cn=localhost, ou=MyOu, o=Ashish PC, c=UK" -alias clientKey -keyalg RSA -keypass password -keystore caclientcert.jks -storepass password -validity 1000


#export client cert to client.cer
keytool -exportcert -rfc -alias clientKey -file client.cer -keypass password -keystore caclientcert.jks -storepass password

#add client.cer to server keystore
keytool -importcert -alias clientKey -file client.cer -keystore caservercert.jks -storepass password -noprompt


#export server cert to server.cer
keytool -exportcert -rfc -alias serverKey -file server.cer -keypass password -keystore caservercert.jks -storepass password

#add server.cer to client keystore
keytool -importcert -alias serverKey -file server.cer -keystore caclientcert.jks -storepass password -noprompt




-- Generated certificates are by default PKCS12 certs so we either have to use curl or SOAPUI to hit certs
-- Put caclientcert.jks to SOAPUI SSL Settings-> KeyStore & also check `Client Authenticaion`.
-- Optionally you can `keyStoreType` to PKCS12 in `application.properties`.
