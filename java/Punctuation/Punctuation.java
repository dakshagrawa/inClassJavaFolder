// Daksh Agrawal
/* Period 7
* 12/08/2025
* 
* Punctuation.java
* 
* >Description:
*   This program scans through a block of text and prints every word that ends
*   with punctuation. A “word” is defined as the sequence of characters between
*   spaces. If the final character of that sequence is not a letter or digit,
*   it is considered punctuation and printed.
*
* >Learning:
*   - How to manually parse text using character-by-character iteration.
*   - How substring indexing works and how to avoid out-of-bounds errors.
*   - How to detect punctuation using ASCII ranges.
*   - How to handle irregular spacing (leading spaces, multiple spaces).
*
* >Pseudocode:
* 	
*	Class header
* 
*   Program Structure:
*     - main() creates a Punctuation object and calls searchIt().
*     - searchIt()[void] prints 3 BL spacing, stores the speech text, and calls getPunctuationWords() and sends the text to it.
*
*   getPunctuationWords(sentence): [void]
*     1. Trim sentence and append one space.
*     2. Set currentWordLength = 0.
*     3. Loop through each character (index i):
*          - If this char and previous char are both spaces:
*                reset currentWordLength and continue.
*          - If this char is a space:
*                extract the previous word using substring(i - currentWordLength, i)
*                if the word ends with punctuation → print it
*                reset currentWordLength
*          - Increment currentWordLength.
*
*   checkForPunctuation(word): [return boolean]
*     - If empty return false
*     - Get last character
*     - Return true if last character is NOT a letter or digit
*
*   printWords(word): [void]
*     - Print the word
*
* >Testing:
*   Tested with the string: " Hello.   World# "
*
*   After trim() → "Hello.   World#"
*   The program correctly:
*     - Prints "Hello." (ends with '.')
*     - Skips the extra spaces between words
*     - Prints "World#" (ends with '#')
*
*   This test confirmed:
*     - Leading spaces do not break the logic (trim() removes them)
*     - Double/triple spaces are handled by the “skip extra spaces” rule
*     - Empty substrings do not cause crashes due to the empty-string guard
*     - The first word is not skipped because only *extra* spaces are ignored
*/

public class Punctuation
{
	public Punctuation()
	{
		//blank
	}
	
	public static void main(String[] args)
	{
		Punctuation punctuation = new Punctuation();
		punctuation.searchIt();
	}
	
	public void searchIt()
	{
		System.out.print("\n\n\n");
		
		// This is the Speech
		String text = new String(
			"Blood, Sweat, and Tears by Winston Churchill " +
			"May 13, 1940 " +
			"Mr. Speaker: " +
			"On Friday evening last I received His Majesty's commission to form a new " +
			"Administration. It was the evident wish and will of Parliament and the nation that this should be conceived on the broadest possible basis and that it should include all parties, both those who supported the late Government and also the parties of the Opposition. " +
			"I have completed the most important part of this task. A War Cabinet has been formed of five Members, representing, with the Liberal Opposition, the unity of the nation. The three party Leaders have agreed to serve, either in the War Cabinet or in high executive office. The three Fighting Services have been filled. It was necessary that this should be done in one single day, on account of the extreme urgency and rigour of events. A number of other key positions were filled yesterday, and I am submitting a further list to His Majesty tonight. I hope to complete the appointment of the principal Ministers during tomorrow. The appointment of the other Ministers usually takes a little longer, but I trust that, when Parliament meets again, this part of my task will be completed, and that the Administration will be complete in all respects. " +
			"Sir, I considered it in the public interest to suggest that the House should be summoned to meet today. Mr. Speaker agreed and took the necessary steps, in accordance with the powers conferred upon him by the Resolution of the House. At the end of the proceedings today, the Adjournment of the House will be proposed until Tuesday, the 21st May, with, of course, provision for earlier meeting, if need be. The business to be considered during that week will be notified to Members at the earliest opportunity. I now invite the House, by the Resolution which stands in my name, to record its approval of the steps taken and to declare its confidence in the new Government. " +
			"Sir, to form an Administration of this scale and complexity is a serious undertaking in itself, but it must be remembered that we are in the preliminary stage of one of the greatest battles in history, that we are in action at many points in Norway and in Holland, that we have to be prepared in the Mediterranean, that the air battle is continuous and that many preparations have to be made here at home. In this crisis I hope I may be pardoned if I do not address the House at any length today. I hope that any of my friends and colleagues, or former colleagues, who are affected by the political reconstruction, will make all allowances for any lack of ceremony with which it has been necessary to act. I would say to the House, as I said to those who’ve joined this government: \"I have nothing to offer but blood, toil, tears and sweat.\" " +
			"We have before us an ordeal of the most grievous kind. We have before us many, many long months of struggle and of suffering. You ask, what is our policy? I will say: It is to wage war, by sea, land and air, with all our might and with all the strength that God can give us; to wage war against a monstrous tyranny, never surpassed in the dark and lamentable catalogue of human crime. That is our policy. You ask, what is our aim? I can answer in one word: victory. Victory at all costs, victory in spite of all terror, victory, however long and hard the road may be; for without victory, there is no survival. Let that be realised; no survival for the British Empire, no survival for all that the British Empire has stood for, no survival for the urge and impulse of the ages, that mankind will move forward towards its goal. " +
			"But I take up my task with buoyancy and hope. I feel sure that our cause will not be suffered to fail among men. At this time I feel entitled to claim the aid of all, and I say, \"Come then, let us go forward together with our united strength.\""
		);

		// Running the punctuation word extraction on the above text (speech)
		getPunctuationWords(text);
		
		System.out.print("\n\n\n");
	}
	
	public void getPunctuationWords(String sentence)
	{
		int currentWordLength = 0;

		// Trim spaces from front and back and add a space in the end so the final word is processed when the loop hits that space.
		sentence = sentence.trim()+" ";

		for(int i = 0; i < sentence.length(); i++ )
		{
			// Skip extra spaces. This prevents empty substrings and keeps word formatted correctly.
			if (sentence.charAt(i) == ' ' && sentence.charAt(i-1) == ' ')
			{
				currentWordLength = 0; 
				continue;
			}

			// When we hit a space, extract the previous word and check punctuation
			if (sentence.charAt(i) == ' ' && checkForPunctuation(sentence.substring((i-currentWordLength),i)))
			{
				printWords(sentence.substring((i-currentWordLength),i));
				currentWordLength = -1; 
			}
			else if (sentence.charAt(i) == ' ')
				currentWordLength = -1;

			// Counting characters in the current word
			currentWordLength++;
		}
	}

	public boolean checkForPunctuation(String thisWord)
	{
		// Prevent empty-string crashes
		if (thisWord.equals(""))
			return false;

		// Get last character and check if it is not A–Z, a–z, 0–9
		char lastChar = thisWord.charAt(thisWord.length()-1);
		return ((int)lastChar<48 || ((int)lastChar>57 && (int)lastChar<65) || ((int)lastChar>90 && (int)lastChar<97) || (int)lastChar>122);
	}
	
	public void printWords(String wordWithPunctuation)
	{
		// Output of the word that ends with punctuation
		System.out.println(wordWithPunctuation);
	}
}
