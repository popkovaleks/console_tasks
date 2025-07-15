package org.example.Model;

import java.io.*;

public class Task {
    private long id;
    private String content;
    private boolean isDone;

    public Task() {};

    public Task(String content) {
        this.id = getIdFromFile();
        this.content = content;
        this.isDone = false;
    }

    private long getIdFromFile(){
        File file = new File("id.txt");

        if(file.exists() && file.length()!=0){
            try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                String line = reader.readLine();
                long id = Long.valueOf(line) + 1;
                return id;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (file.length() == 0 || !file.exists()){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))){
                long id = 1;
                writer.write("1");
                return id;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
