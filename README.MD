# Simple News App 

This repository contains the code for a simple news application written using Java. This simple news application uses [The Google News API](https://newsapi.org/ ) to gather the top headlines in a user specified country. Once the application has the information for the top headlines for the country it then shows the Title and the Content in a graphical user interface for 10 of the articles. 


## Important Notes
In order to use the program the user will need to provide a two letter abbreviation for the country. I have provided a couple of the abbreviations below for your conveinence. 

United States - us<br/>
Australia - au<br/>
Canada - ca<br/>
China - ch<br/>
England - gb<br/> 
Mexico - mx<br/>


## Quick Links

[Java SE 14 Download](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)<br/>
[Gson User Guide](https://sites.google.com/site/gson/gson-user-guide)<br/>
[Google News API](https://newsapi.org/)<br/>


## Getting Started

To make this process easier for you I have included an executable jar file. The executable jar file is named: "NewsApp.jar". If you wish to run the program you can simply double click on the executable jar and it should run successfully. If you would like to compile and build the application yourself you can follow the instructions below.  

### Prerequisites

To run this Project, you will need to have Java version 14.0.2 (see Quick Links for a direct link for the download). 

This program also imports GSON. I have included the gson-2.8.6.jar file in the src directory. 

This program requires an API key. API Keys are considered sensitive information and should not be shared publicly. If you would like to manually build this application you will need to provide your own API Key. Please see the Google News API link in quick links section to create your own API key. 

Once you have created your own API key you can simply update the API key in two different files the NewsApp.java and the NewAppTest.java file.  When you open these files you will see a section at the top that says:

apiKey.append("Put Your API Key HERE, between the quotation marks");

Simply place your API key between the quotation marks. 


### Compiling the project 

Once you have added your own api key and you have the required software installed you are ready to compile the program. 

1. Open a command line prompt session such as Terminal or CMD
2. Change your current working directory to the location you have downloaded the project 
3. Change your directory into the root of the project folder 
4. Change your directory into the src folder
5. Run the following command to compile the project: 

javac -cp gson-2.8.6.jar NewsApp.java Article.java Gui.java ArticleList.java ConnectionStatus.java


### Running the project 

Once you have compiled the project you should be able to successfully run the project by using the following command (based on the user operating system). 

#### macOS

java -cp .:gson-2.8.6.jar NewsApp

#### Windows

java -cp .;gson-2.8.6.jar NewsApp


## Testing using Unit Tests

I have included a simple test that triggers an ActionEvent. This test simulates the response if a user were to leave the country selection field empty. You can find the test in the NewAppTest.java file. 


## Wrapping up 

If you have any questions or concerns regarding the program you are more than welcome to email me and I will do my best to assist you. 
