package com.awl.jspbook.ch04;

public class QuizBean implements java.io.Serializable {
  private String question;
  private String answer1;
  private String answer2;
  private String answer3;
  private String url;
  private int rightAnswer;
  private boolean right;
  private int guess;

  public String getQuestion() {return question;}
  public void setQuestion(String question) {this.question = question;}

  public String getAnswer1() {return answer1;}
  public void setAnswer1(String answer1) {this.answer1 = answer1;}

  public String getAnswer2() {return answer2;}
  public void setAnswer2(String answer2) {this.answer2 = answer2;}

  public String getAnswer3() {return answer3;}
  public void setAnswer3(String answer3) {this.answer3 = answer3;}

    public int getRightAnswer() {return rightAnswer;}
    public void setRightAnswer(int rightAnswer) {
	this.rightAnswer = rightAnswer;
    }

  public String getUrl() {return url;}
  public void setUrl(String url) {this.url = url;}


  public void setGuess(String guess) {
    this.guess = Integer.parseInt(guess);
    right      = (this.guess == rightAnswer);
  }

  public String getGuess() {
    if(guess == 1) return answer1;
    if(guess == 2) return answer2;
    if(guess == 3) return answer3;
    return null;
  }

  public boolean isRight() {return right;}

}
