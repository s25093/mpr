import message.EncodingMethod;
import message.Message;
import message.MessageEncoder;
import message.ShiftDirection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MessageEncoderTest {

    @Mock
    EncodingMethod encodingMethod;

    @Test
    public void encodeTest() {
        Message message = new Message("kapibara");
        when(encodingMethod.getAmount()).thenReturn(2);
        when(encodingMethod.getDirection()).thenReturn(ShiftDirection.FORWARD);

        MessageEncoder encoder = new MessageEncoder(encodingMethod);

        Message encodedMessage = encoder.encode(message);

        verify(encodingMethod, Mockito.times(message.getText().length())).getAmount();

        assertEquals("mcrkdctc", encodedMessage.getText());
    }


}
