package interface_adapter.sign_language_recognition;

import java.io.IOException;

/**
 * Interface for handling predictions generated by the sign language recognition process.
 */
public interface PredictionListenerInterface {

    /**
     * Handles a prediction result from the recognition system.
     * This method is called when a prediction is generated, providing the result as a string.
     * Implementations can define how the prediction is processed, displayed, or logged.
     *
     * @param prediction the predicted result as a string
     * @throws IOException if an I/O error occurs during processing
     * @throws InterruptedException if the processing is interrupted
     */
    void onPrediction(String prediction) throws IOException, InterruptedException;
}
