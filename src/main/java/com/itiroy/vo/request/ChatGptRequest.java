package com.itiroy.vo.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatGptRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String model;
    private String input;
    private boolean store;
    private List<Message> messages;

    public ChatGptRequest() {}

    public ChatGptRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isStore() {
        return store;
    }

    public void setStore(boolean store) {
        this.store = store;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChatGptRequest that = (ChatGptRequest) o;
        return store == that.store && Objects.equals(model, that.model) && Objects.equals(input, that.input) && Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, input, store, messages);
    }
}
