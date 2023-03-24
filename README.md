# Java - Java MCV GUI

This is a **Java - Maven Project**.
This project is a seach engine having some features in order to work with **.csv** files. Using a lightweight GUI.

# Modules
Four modules were created:

|Module                |Description                          |Class                        |
|----------------|-------------------------------|-----------------------------|
|GUI Search|`Call a GUI for Search in CSV Files. Previously listed in .xml file.`            |GUIRunner            |
|Bulk Download          |`Performed a file bulk download.`            |BulFileDownload            |
|Store Data from CSV    |`Open each .csv file and store each record in database. Defined template for logbooks.`|BulkLogBook|
|Search and Copy File   |`Performed a search and downloads the specified files from the path read in the .csv file.`|SearchCSVandCopy|

# JDK
- Open JDK 11 -> [Amazon Coretto](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)

# Dependencies
- jakarta.xml.bind
- com.sun.xml.bind
- org.eclipse.persistence
- com.microsoft.sqlserver
- org.apache.poi
- commons-io

# Bussines Logic
1. Retrieve values from `.csv` file that contains url address to permits files.
2. Create an object with a defined structure of logbook.

|Id Matrix|TC Document Control|Date Correspondence|Type|Subject|Author|Original Received|Comments|Status FileNet|References|
|---|---|---|---|---|---|---|---|---|---|
|||||||

3. The first approach is that the logbook object contains every field but (To future implementation would be required a normalization process for avoiding nulls and recurrency).
4. As next step a search is performed using `LinkedList` (in order to improve performance) every record is stored for a `stream` search.
5. Finally a new `JTableModel` is defined for display the results to be selected to download.

# Search GUI Screencap
![GUI - File Search](https://i.imgur.com/z9ox8ma.png)

# Configuration Parameters
## MV Parameters
Secure Authentication using JDBC:
>-Djava.library.path="C:\folder_path\sqljdbc_9.4\enu\auth\x64"

## Creation a .key and .cert with OpenSSL
In the path: `C:\Program Files\Git\usr\bin>openssl.exe ` is available a open tool for creation certs and keys.
Using the following command:
>C:\Program Files\Git\usr\bin>openssl.exe req -x509 -nodes -sha256 -days 3650 -subj "/CN=Local" -newkey rsa:2048 -keyout "C:\path_destination\key_name.key" -out "C:\path_destination\cert_destination.crt"

## Export a Cert to KeyStore for SSL Encryption
The following command is required to setup a new certificate in order to SSL connections.
>keytool -importcert -trustcacerts -file "C:\dir_path\tcenergy.crt" -alias "tc_cert" -keystore "C:\Program Files\Amazon Corretto\jdk19.0.2_7\lib\security\cacerts"
>
`Additional Info:` [Wiki - Keystore Repository](https://github.com/jrwhetse/jrwhetse.github.io/wiki/Java-Keystores)

## Use SSL Poke to test Java SSL connection
Java uses the cacerts file as its certificate authority to validate certificates used in https connections made by Java applications. It is useful to be able to verify that the cacerts file has the correct certificates added to it to connect securely and this is a common scenario when connecting to internal sites in a network that use an internal PKI to issue certificates for internal sites. Atlassian (the company that makes Jira and Confluence) has created a small Java program called SSL Poke to test this connectivity.
>[SSLPoke Class](https://matthewdavis111.com/java/poke-ssl-test-java-certs/)
>
>[Atlassian Explanation ](https://confluence.atlassian.com/jira/connecting-to-ssl-services-117455.html)

# Issues & Common Errors
## Driver not properly configured for integrated authentication.
`Error:`The driver could not establish a secure connection to SQL Server by using Secure Sockets Layer (SSL) encryption.

>[Driver could not establish a secure connection](https://support.tibco.com/s/article/The-driver-could-not-establish-a-secure-connection-to-SQL-Server-by-using-Secure-Sockets-Layer-SSL-encryption-Error-SQL-Server-returned-an-incomplete-response)

Download the Microsoft JDBC Driver 4.2 for SQL Server, a Type 4 JDBC driver that provides database connectivity through the standard JDBC application program interfaces (APIs) available in Java Platform, Enterprise Editions.
>ODBC: [Microsoft JDBC Driver 4.2 for SQL Server](https://www.microsoft.com/en-us/download/details.aspx?id=54671)