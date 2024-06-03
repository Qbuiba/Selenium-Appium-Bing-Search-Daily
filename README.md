# Microsoft Bing searching rewards

Currently, Microsoft encourages users to use the Edge browser and Bing search tool. Users can earn 150 points per day by searching on PC and 100 points per day on mobile phones.
For more information: https://rewards.bing.com/

![image](https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily/assets/37890918/8b289917-0f4a-4b1e-993c-da3bb817d1a9)

With these points, users can redeem rewards such as Amazon or Microsoft gift cards, as well as gift cards for various gaming brands.

![image](https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily/assets/37890918/174042a2-f991-443e-9b02-3aa05c22984d)

## PART 0: HOW TO RUN TEST CASES:
![image](https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily/assets/37890918/feee8edf-d766-4d2e-adcd-0d1eec08de02)

![image](https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily/assets/37890918/a33fab6f-f4dd-48bd-a118-f37b883172bc)


This project contains two sections: Selenium to interact with the Edge browser and Appium to interact with Android phones.

## PART 1: SELENIUM
- [Installation](#installation)

1. Clone the repository:
```bash
 git clone https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily.git
```

2. Install dependencies:
- Install Microsoft Edge browser: https://www.microsoft.com/en-us/edge
- Donwload the `msedgedriver.exe` file with browser compatible version: https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/?form=MA13LH


- [Usage](#usage)
1. Copy any long paragraph (more than 30 sentences) and paste it into dataForBingSearch.txt. This file is parsed into multiple sentences for every search.
   
![image](https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily/assets/37890918/ec0a9758-926b-4826-9e7b-277219a3cb56)

2. Click on the Run icon next to the method. This is JUnit framework; you can run the single test.

![image](https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily/assets/37890918/bd82636e-cebd-4712-b66b-b5db0f42b5b5)

3. It will running like this

![image](https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily/assets/37890918/d0e4d7e2-fa05-459d-86d7-a53ba181eaad)


## PART 2: APPIUM
- [Installation](#installation)

1. Clone the repository:
```bash
 git clone https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily.git
```

2. Install dependencies:
- Install Appium Server: https://appium.io/docs/en/2.0/quickstart/install/
- Install Appium Inspector tool: https://github.com/appium/appium-inspector/releases (Optional: this tool is used to catching the Xpath of elenment in mobile application)
- Install Appium DashBoard plugin: https://github.com/sudharsan-selvaraj/appium-dashboard-plugin (Optional: this tool for monitor the running session of Appium at local host: )
  
- [Usage](#usage)
1. Start the Appium server:
- Open terminal, run the command: 
`appium server --address localhost --port 4723 --use-drivers uiautomator2 --base-path /wd/hub --use-plugins appium-dashboard`

or if you don't want to start Appium dashboard
`appium server --address localhost --port 4723 --use-drivers uiautomator2 --base-path /wd/hub`

![image](https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily/assets/37890918/15d95df1-6178-4333-9b89-ebf6b006a4fc)

2. Connect your Android phone to laptop by cable, remember to open debugging mode of your phone: https://developer.android.com/studio/debug/dev-options

3. Copy any long paragraph (more than 30 sentences) and paste it into dataForBingSearch.txt. This file is parsed into multiple sentences for every search.
   
![image](https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily/assets/37890918/ec0a9758-926b-4826-9e7b-277219a3cb56)

4. Click on the Run icon next to the method to running the test

5. Access to http://localhost:4723/dashboard to view the running session

![image](https://github.com/Qbuiba/Selenium-Appium-Bing-Search-Daily/assets/37890918/ea12001e-d134-47e0-871c-2e22d12595aa)


That's it! Enjoy earning Microsoft points. Have a good day!


## CONTRIBUTING
You can contribute to the code by adding more features and functions:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Make your changes.
4. Push your branch: `git push origin feature-name`.
5. Create a pull request.

 ## LICENSE
- [License](#license)
This project is just a free-time project for fun, not under any license.



