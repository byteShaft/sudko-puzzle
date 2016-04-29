package byteshaft.com.sudko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int board [][];
    private int start[][];

    private Button clear;
    private Button square;
    private Button guess;
    private Button quit;
    private TextView textView;
    private SudokuPuzzle sudokuPuzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sudokuPuzzle = new SudokuPuzzle();

        textView = (TextView) findViewById(R.id.text_view);

        clear = (Button) findViewById(R.id.clear);
        square = (Button) findViewById(R.id.square);
        guess = (Button) findViewById(R.id.guess);
        quit = (Button) findViewById(R.id.quit);

        clear.setOnClickListener(this);
        square.setOnClickListener(this);
        guess.setOnClickListener(this);
        quit.setOnClickListener(this);


        textView.setText(sudokuPuzzle.toString());
    }

    public void addInitial(int row, int col, int value){
        //add initial values to puzzle
        if (row>=0 && row<=9 && col >=0 && col <=9 && value >=1 && value <=9){
            start [row][col] = value;
            board [row][col] = value;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clear:
                
                break;

            case R.id.square:
                // TODO: 29/04/2016  squre action
                break;

            case R.id.guess:
                // TODO: 29/04/2016  guess action
                break;

            case R.id.quit:
                finish();
                break;
        }
    }
}
