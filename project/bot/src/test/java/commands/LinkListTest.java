package commands;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tinkoff.edu.java.bot.dto.ListLinkResponse;
import ru.tinkoff.edu.java.bot.model.Link;
import ru.tinkoff.edu.java.bot.commands.ListCommand;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LinkListTest {

    @Mock
    private LinkService client = Mockito.mock(LinkService.class);

    @Mock
    private Update mockUpdate;

    @Mock
    private Message mockMessage;

    @Mock
    private Chat mockChat;

    private Long id = 1L;

    @Test
    public void noLinks(){
        when(mockUpdate.message()).thenReturn(mockMessage);
        when(mockMessage.chat()).thenReturn(mockChat);
        when(mockMessage.chat().id()).thenReturn(id);
        ListCommand listCommand = new ListCommand(client);
        SendMessage result = listCommand.handle(mockUpdate);
        assertAll(() -> assertEquals(result.getParameters().get("text"), "Нет отслеживаемых ссылок"));
    }


    @Test
    public void existLinks(){
        when(mockUpdate.message()).thenReturn(mockMessage);
        when(mockMessage.chat()).thenReturn(mockChat);
        when(mockMessage.chat().id()).thenReturn(id);
        when(client.getLinks(id)).thenReturn(new ListLinkResponse(List.of(
                new Link(id, ("https://github.com/sanyarnd/tinkoff-java-course-2022/").toString()),
                new Link(id, ("https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c").toString())), 2).links());
        ListCommand listCommand = new ListCommand(client);
        SendMessage result = listCommand.handle(mockUpdate);
        String res = """
                Список отслеживаемых ссылок:
                https://github.com/sanyarnd/tinkoff-java-course-2022/
                https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c
                """;
        assertAll(() -> assertEquals(result.getParameters().get("text"), res));
    }
}
