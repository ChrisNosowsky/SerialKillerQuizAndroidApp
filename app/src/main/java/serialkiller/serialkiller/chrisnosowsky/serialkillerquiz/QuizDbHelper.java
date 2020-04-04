package serialkiller.serialkiller.chrisnosowsky.serialkillerquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import serialkiller.serialkiller.chrisnosowsky.serialkillerquiz.QuizContract.*;

import com.example.chrisnosowsky.serialkillerquiz.R;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SerialKillerQuiz.db";
    private static final int DATABASE_VERSION = 4;

    private SQLiteDatabase db;


    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionsTable.IMAGE_ID + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }
    private void fillQuestionsTable() {
        Question q1 = new Question("Who is Ted Bundy?", "A. An attractive serial killer who used his looks to commit murder, necrophilia, and kidnapping of young women in the 1970s",
                "B. A serial killer in the 1990s who killed and kidnapped women and children",
                "C. A serial killer who started his crimes at a young age and moved them into his adult years, killing young women with blonde hair and blue eyes ", "A serial killer in the 1980s who dismembered women and children for fun", 1, Question.DIFFICULTY_EASY, R.drawable.image1);
        addQuestion(q1);
        Question q2 = new Question("What crimes did Jeffrey Dahmer commit?", "A. Kidnapping", "B. Murder", "C. Kidnapping, murder, necrophilia, and rape","D. Dismemberment", 3, Question.DIFFICULTY_EASY, R.drawable.image3);
        addQuestion(q2);
        Question q3 = new Question("Whos is the Green River Killer?", "A. William Bonin", "B. Gary Ridgway", "C. Earle Nelson","D. Albert Fish", 2, Question.DIFFICULTY_EASY, R.drawable.image4);
        addQuestion(q3);
        Question q4 = new Question("Who is Edward Gein?", "A. A serial killer who was also known as the body snatcher, he used the skin of his victims to make furniture and clothing.",
                "B. A russian serial killer who murdered, and sexually assaulted over 50 women and children",
                "C. A serial killer in the 1900s who killed, cannibalized, and raped children. He was said to kill over 100 children","D. A serial killer in the 1920's who killed 20+ children.", 1, Question.DIFFICULTY_EASY, R.drawable.imag5);
        addQuestion(q4);
        Question q5 = new Question("How many children did Pedro Lopez kill?", "A. Over 300", "B. Around 100", "C. 25","D. 4", 1, Question.DIFFICULTY_EASY, R.drawable.image2);
        addQuestion(q5);
        Question q17 = new Question("How many people did the Cleveland torso murderer kill and what years did they happen in?", "A. 15, 1990-1993", "B. 10, 1987-1990", "C. 5, 1954-1956","D. 20, 1935-1938", 4, Question.DIFFICULTY_EASY, R.drawable.image17);
        addQuestion(q17); //add d option
        Question q21 = new Question("How many children did Luis Gararito murder?", "A. 300+", "B. 100", "C. 55","D. 250", 1, Question.DIFFICULTY_EASY, R.drawable.image21);
        addQuestion(q21);
        Question q23 = new Question("Who was Roger Kibbes first victim?", "A. Lou Ellen Burleigh", "B. Barbara Ann Scott", "C. Stephanie Brown","D. Lora Heedrick", 1, Question.DIFFICULTY_EASY, R.drawable.image23);
        addQuestion(q23);
        Question q22 = new Question("Why did Milton Johnson go to jail for the first time?", "A. Brutal Rape", "B. Drug Use", "C. Theft","D. Manslaughter", 4, Question.DIFFICULTY_EASY, R.drawable.image22);
        addQuestion(q22);
        Question q30 = new Question("What was Harold Shipmans nickname? and how many people did he murder?", "A. Devil of England, 108+", "B. New England Slaughterer, 304+", "C. Dr. Death, 250+","D. Shotgun stalker, 57+", 3, Question.DIFFICULTY_EASY, R.drawable.image30);
        addQuestion(q30);

        //MEDIUM//
        Question q6 = new Question("What crimes did Andrei Chickatilo commit?", "A. Necrophilia, cannibalism, evisceration, and mutilation", "B. Rape", "C. Rape, murder, kidnapping","D. Kidnapping", 1, Question.DIFFICULTY_MEDIUM, R.drawable.image5);
        addQuestion(q6);
        Question q7 = new Question("What was David Berkowitz’ nickname?", "A. Zodiac Killer", "B. Son Of Sam", "C. The HitchHikers Killer","D. The Mad Butcher", 2, Question.DIFFICULTY_MEDIUM, R.drawable.image6);
        addQuestion(q7);
        Question q8 = new Question("What crimes did Albert Fish commit and when did he commit them?", "A. Kidnapping, pedophilia, caniblism, and murder; 1924-1934", "B. Rape, kiddnapping; 1940-1942", "C. Murder, necrophilia; 1918-1923","D. Murder, 1956-1957", 1, Question.DIFFICULTY_MEDIUM, R.drawable.image7);
        addQuestion(q8);
        Question q9 = new Question("How many murders was John Wayne Gacy convicted of?", "A. 47", "B. 35", "C. 33","D. 28", 3, Question.DIFFICULTY_MEDIUM, R.drawable.image11);
        addQuestion(q9);
        Question q10 = new Question("Where is Aileen Wuornos from?", "A. Washington, DC", "B. Troy, MI", "C. Miami, FL","D. Cincinnati, OH", 2, Question.DIFFICULTY_MEDIUM, R.drawable.image10);
        addQuestion(q10);
        Question q16 = new Question("Why did Richard Trenton Chase move out of his mothers home?", "A. She took all of his money", "B. She tried to rape him", "C. He thought she was going to poison him","D. She drank too much and threatened to kill him", 3, Question.DIFFICULTY_MEDIUM, R.drawable.image16);
        addQuestion(q16); //add d option
        Question q18 = new Question("How many life sentences was John Justin Bunting sentenced to?", "A. 20", "B. 11", "C. 8","D. 21", 2, Question.DIFFICULTY_MEDIUM, R.drawable.image18);
        addQuestion(q18);
        Question q19 = new Question("How did Antone Charles Costa die?", "A. Police shootout", "B. Hung himself", "C. Dismemberment","D. Shot himself in the head with a shotgun", 2, Question.DIFFICULTY_MEDIUM, R.drawable.image19);
        addQuestion(q19);
        Question q20 = new Question("What states did Larry Eyler kill in?", "A. California, Washington, Nevada, Utah", "B. Kansas, Nebraska, Texas, Iowa", "C. Wyoming, Colorado, Arizona, New Mexico","D. Indiana, Illinois, Ohio, Kentucky, Wisconsin", 4, Question.DIFFICULTY_MEDIUM, R.drawable.image20);
        addQuestion(q20);
        Question q24 = new Question("Where was Vasili Konnaroff born?", "A. India", "B. Russia", "C. America", "D. Mexico", 2, Question.DIFFICULTY_MEDIUM, R.drawable.image24);
        addQuestion(q24);

        //HARD//
        Question q11 = new Question("What did Edmund Kemper do after he killed his mother?", "A. Threw her in the dumpster", "B. Cut off her head and then raped her. Then he cut her tongue off and put it in the garbage disposal", "C. Ate her corpse","D. Dumped it to the bottom of a lake", 2, Question.DIFFICULTY_HARD, R.drawable.image8);
        addQuestion(q11);
        Question q12 = new Question("Who is Tsutomu Miyazki?", "A. A japanese serial killer who murdered older men", "B. A japanese serial killer who murdered and raped little girls", "C. A japanese serial killer who kidnapped and killed teenage girls", "A chinese serial killer who murdered little boys", 2, Question.DIFFICULTY_HARD, R.drawable.image9);
        addQuestion(q12);
        Question q13 = new Question("How many people did Jack the Ripper kill? And what were their names?", "A. 7; Mary Nichols, Mary Kelly, Emma Elizabeth Smith, Martha Tabram, Annie Chapman, Elizabeth Stride, Catherine Eddowes.", "B. 3; Mary Allen, Eleanor Louisa, Myrtle Witfield", "C. 5; Catherine Appleton, Dorthy Nash, Frances Barlow, Elsa Hartford, Harriet Lancaster", "3; Dorthy Nash, Myrtle Witfield, Lorry Abrams",1, Question.DIFFICULTY_HARD, R.drawable.image13);
        addQuestion(q13);
        Question q14 = new Question("What was Richard Ramirez wife’s name? And when and where did they marry?", "A. Andrea Jackson, January 22nd, 1999. San Francisco, California ", "B. Louise Hamilton, November 3rd, 1993. Mission Viejo, California", "C. Doreen Lioy, October 3rd, 1996. San Quentin Prison, California","Sophia Clemens, May 2rd, 1993. San Jose, California", 3, Question.DIFFICULTY_HARD, R.drawable.image14);
        addQuestion(q14);
        Question q15 = new Question("Who is the main suspect tied to the “Zodiac Killer”?", "A. Arthur Leigh Allen", "B. Robert Lee", "C. Jerry Smith", "D. Ted Kaczynski",1, Question.DIFFICULTY_HARD, R.drawable.image12);
        addQuestion(q15);
        Question q26 = new Question("What day was Peter Lundin arrested on and for what?", "A. July 30th, 2 murders", "B. July 2nd, 10 murders", "C. July 5th, 4 murders","D. July 20th, 6 murders", 3, Question.DIFFICULTY_HARD, R.drawable.image26);
        addQuestion(q26);
        Question q27 = new Question("Who was John Allen Muhammad's accomplice?", "A. Jerry Stevens", "B. Juan Boyd", "C. Lee Malvo","D. Malcome Dee", 3, Question.DIFFICULTY_HARD, R.drawable.image27);
        addQuestion(q27);
        Question q25 = new Question("What was Randy Steven Krafts killing tactic, how long did he actively kill and how many people did he kill?", "A. Shooting, 5 years, 17", "B. Stabbing, 10 years, 25", "C. Strangling, 11 years, 67","D. Drowning, 2 years, 12", 3, Question.DIFFICULTY_HARD, R.drawable.image25);
        addQuestion(q25);
        Question q28 = new Question("What film was based off Gordan Northcotts murders?", "A. Maniac", "B. The Changeling", "C. Psycho", "D. Creep",3, Question.DIFFICULTY_HARD, R.drawable.image28);
        addQuestion(q28);
        Question q29 = new Question("What was Timothy Mcreighs last meal?", "A. KFC", "B. Steak and Shrimp", "C. 2 pints of chocolate chip ice cream","D. Chicken, teriyaki, stir fry", 3, Question.DIFFICULTY_HARD, R.drawable.image29);
        addQuestion(q29);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionsTable.IMAGE_ID, question.getImageID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setImageID(c.getInt(c.getColumnIndex(QuestionsTable.IMAGE_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestions(String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setImageID(c.getInt(c.getColumnIndex(QuestionsTable.IMAGE_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
