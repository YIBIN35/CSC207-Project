# GestureBridge

### Overview
Gesture bridge is a **sign language translation application** that captures sign language gestures via a camera, 
interprets the signs, converts them into written text, and then vocalizes the text for an accessible, real-time 
communication experience.  

The application will be both educational and assistive, supporting interactions between individuals who 
communicate in sign language and those unfamiliar with it, bridging communication barriers effectively. The 
project’s primary user base will be individuals who are deaf or hard of hearing, and its secondary users include 
family, friends, and colleagues who wish to communicate seamlessly with them.

### Contributors
- Wania Sikandar Gondal (waniagondal)
- Yibin Wang (YIBIN35)
- Fang (Trent) Sheng (F4NG66)
- Gavin Jiawei Song (gavinsong45)
- Shuxiao Song (SSX-song)

### Table of Contents
- [**Features**](#features)
- [**Installation Instructions**](#installation-instructions)
- [**Usage Guide**](#usage-guide)
- [**License**](#license)
- [**Feedback and Contributions**](#feedback-and-contributions)

### Features
- **Real-Time Sign Language Recognition**: Recognized sign language through webcam feed and translates them instantly.
The project currently supports fingerspelling only, but more vocabulary will be added in the future.
```
    public void startRecognition() throws IOException, InterruptedException {
        predictor.startRecognition(this::predictionToPresenter);
    }
    private void predictionToPresenter(String prediction) {
        SignLanguageRecognitionOutputData outputData = new SignLanguageRecognitionOutputData(prediction);
        signLanguagePresenter.updateView(outputData);
    }
```


- **Language Translation**: Translates recognized language into multiple languages, allowing the user to communicate
with a wider range of people.
```
    String translatedText = languageDataAccessObject.translate(language, text);
    SignLanguageTranslationOutputData signLanguageTranslationOutputData =
        new SignLanguageTranslationOutputData(translatedText);
    signLanguageTranslationPresenter.prepareSuccessView(signLanguageTranslationOutputData);
```


- **Text-to-Speech Conversion**: Vocalizes the recognized text for real-time communication.
```
    TextToSpeechOutputData outputData = textToSpeechService.convertTextToSpeech(inputData);
    outputBoundary.prepareOutput(outputData);
```


- **Voice Customization**: Allows the user to customize the speech output by modifying voice type, pitch, and speed.
```
    voiceSettingsDataAccessObject.changeSettings(audioSettings);

    final CustomizeVoiceOutputData customizeVoiceOutputData = new CustomizeVoiceOutputData(audioSettings, false);
    voiceSettingsPresenter.prepareSuccessView(customizeVoiceOutputData);
```


- **Speech-to-Text Transcription**: Transcribes voice input from the other individual into text displayed for the deaf
or hard of hearing.
```
    public void processSpeech(SpeechToTextInputData inputData) throws Exception {
        String onSpeechRecognition = speechRecognizer.recognize(inputData.getAudioData());
        SpeechToTextOutputData outputData = new SpeechToTextOutputData(onSpeechRecognition);
        speechToTextPresenter.deliverTranscription(outputData);
    }
```

### Installation Instructions
#### Requirements
To run this project successfully, you will need to install the following:
- Python (version 3.7 or higher)
- MediaPipe (version 0.10.18)
- NumPy (version 1.26.4)
- OpenCV-Python (version 4.10.0.84)
- Pytorch (version 2.5.1)
- TorchVision (version 0.20.1)
- Google Cloud Libraries (version 26.49.0): Cloud Translation API, Cloud Speech-to-Text API, Cloud Text-to-Speech API
- CSC207 CheckStyle

#### Installing Python
To install Python (version 3.7 or higher), click this link and follow the instructions: [Download Python](https://www.python.org/downloads/)

#### Installing Python Model Dependencies
To install Python and MediaPipe dependencies, you can download them using the
model_requirements.txt file in the src folder (this should be performed in Python):
```
pip install -r model_requirements.txt
```
To install the Google Cloud APIs, please follow the instructions provided in the links below:
- [Google Cloud Translation API](https://cloud.google.com/translate/docs/setup)
- [Google Cloud Text-to-Speech API](https://cloud.google.com/text-to-speech/docs/before-you-begin)
- [Google Cloud Speech-to-Text API](https://cloud.google.com/speech-to-text/docs/before-you-begin)

#### Installing Checkstyle
- We recommend using IDEs for this project (e.g., IntelliJ IDEA, Eclipse). To install the CSC207 checkstyle, make sure the file
mystyle.xml is included in your repository, then paste the following code to checkstyle.xml file
```
<ConfigurationLocation id="a12e12d0-c511-43fb-8087-db6b548f5394" type="PROJECT_RELATIVE" scope="All" description="207 Checks">$PROJECT_DIR$/mystyle.xml</ConfigurationLocation>
```
- Set the checkstyle as default to check your code any time.

#### Common Issues
Q: I added the dependencies in my pom file, but the program still doesn't run, why?

A: Try clicking on the pom file, go to the "Maven" option, and click "Reload Project". If it doesn't work ,try re-installing the dependencies
and checking if they are in the right version


Q: I tried running the program but I'm getting API errors, why?

A: It might be because you haven't added an appropriate API key. For Google Cloud APIs, you need to generate them on the console and use your own
API to access the functions. For more instructions, click [here](https://cloud.google.com/apis/docs/getting-started)
   

### Usage Guide
- After the project is downloaded, please allow access to your webcam to enable real-time
sign language recognition feature


- Gesture the content you wish to express, and it will show up in the “Sign Language 
Recognition” text box below.


- To translate the recognized into different languages to communicate with different 
individuals, select a language from the drop-down menu below the text box and click on 
the “Translate” button.


https://github.com/user-attachments/assets/1fb94de8-56ec-4cf3-808c-aa642d2d0cf1




- To convert the recognized sign language from text to speech, click on the “Text to 
Speech” button, and the speech output will be generated. If you wish for the speech output
to be in a different language, please ensure you have translated the text into the desired 
language before using this function.


https://github.com/user-attachments/assets/98782227-67ba-4af5-92a1-0d3fb0cc90cf






- To modify the voice of the speech output, click on “Settings”. A pop-up page will appear 
with a series of sliders to help you adjust the voice type (male/female), pitch, speed 
(and volume) of the speech output.



https://github.com/user-attachments/assets/1e16e11c-c808-40c7-af77-c3f6855e25c7





-  To transcribe spoken language to text, click on the “Begin Transcription” button and 
speak into the microphone, then click “End Transcription”. Words will appear in 
the transcription area.


https://github.com/user-attachments/assets/2aa36b9e-4560-4695-8f43-04b9d3be390e





### License
This code is licensed under the terms of the Creative Commons license.

### Feedback and Contributions
#### Feedback
We value your opinions and suggestions to help us improve the project!
Here's how you can provide feedback:

**How to give feedback**

- Write an email to wania.gondal@mail.utoronto.ca, add "GestureBridge" to the subject.
- Clearly state the issue or suggestion.
- For issues and bugs,  please include a screenshot or code snippet if possible; For suggestions,
 be specific about which feature or part of code you are referring to.

**What to expect after giving feedback**
- You will receive an acknowledgement of your feedback within 48 hours.
- Feedback is viewed weekly by the maintainers.
- Please check the issue tracker for further updates. If you provided your GitHub username when
giving feedback, we will notify you when posting new changes.

#### Contributions
Your contributions will help us greatly enhance the project! Whether it's fixing bugs, adding new
features, or improving documentation, your efforts make a difference.

**How to Contribute**
1. Fork the Repository
   - Go to GestureBridge's GitHub repository
   - Click on the "Fork" button to create a copy of the repository.
2. Clone Your Fork
   - Go to your forked repository and click on the "Code" button on the top right. Copy the URL
that appears.
   - Go to your IDE, use "Get from VCS" to create a new project with your URL, or you can 
use `git clone` in the terminal
3. Create a New Branch
   - Select "New Branch" option in your IDE toolbar, or you can use the following git command:
    ```
    git checkout -b feature/your-feature-name
    ```
4. Code Your Changes
   - Add code, documentation, or fix a bug mentioned in the "Issues" section. Make sure to
follow the CSC207 Checkstyle!
5. Commit Your Changes
   - If you have GitHub plugin installed, commit through the IDE toolbar, or you can commit
using the following git command:
    ```
    git commit -m "Description of your changes"
    ```
   - Make sure to include descriptions in your commits!
6. Push Your Changes
   - You can either push through the Git toolbar in your IDE, or use the following git
command line:
    ```
    git push origin feature/your-feature-name
    ```
7. Submit a Pull Request
   - Open a pull request on GitHub, add the maintainer to your reviewers. And congratulations!
You just helped make a difference to this project!

**Guidelines for a Good Merge Request**
- Make sure your branch is up to date with the main branch to avoid merge conflicts
- Include a clear title and detailed description for your pull request
- Double-check your code before you push to ensure checkstyle errors were reported 

**Review and Merge Protocols**
- Contributions and pull requests are reviewed weekly by the maintainers
- Your contribution should be constructive, addressing either an existing issue or 
help add a new feature
- Your contribution should pass all checkstyle scans before being pushed
- Once approved, your pull request will be merged to the main branch, and you will
be credited as a contributor!
