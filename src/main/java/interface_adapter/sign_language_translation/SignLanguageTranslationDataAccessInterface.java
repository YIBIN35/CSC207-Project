package interface_adapter.sign_language_translation;

/**
 * Data Access Interface for the Sign Language Translation use case.
 * Defines the contract for accessing signLanguageTranslationDisplay-related data and services.
 */
public interface SignLanguageTranslationDataAccessInterface {

    /**
     * Translates the given text into the specified language.
     *
     * @param language the target language for the signLanguageTranslationDisplay
     * @param text     the text to be translated
     * @return the translated version of the text
     */
    String translate(String language, String text);
}
