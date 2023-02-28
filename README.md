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

