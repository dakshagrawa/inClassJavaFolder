## <div align="right"> [Instructions for Code](https://mvhs-fuhsd.org/john_conlin/Java/HW_folder_Java/1stSemDocs/Unit04-IfElse/Postage.pdf) </div>

---

# 📬 Postage Calculator (Postage.java)

This Java program figures out the mailing cost for US Post Office packages based on weight.



## ✨ What it Does

* **Shows a Menu:** Gives you options for different mail types.
    * **(1) First Class (domestic):** Cost is by ounce.
    * **(2) Postcard (domestic):** Fixed price.
    * **(3) Media Mail:** Cost is by pound.
* **Calculates Price:** Uses fixed rates to find the total cost.
* **Checks Your Input:** Makes sure you pick a real option and enter a valid weight.
* **Shows Result:** Prints your mail type, weight, and the final cost.



### ⚙️ Mail Prices (Based on the Code)

The program uses these rates for the calculation:

| Option | Mail Type | How it's Charged | Rate Used |
| :--- | :--- | :--- | :--- |
| **1** | First Class | Ounces | **$0.78** for the first oz. + **$0.29** for each extra oz. |
| **2** | Postcard | Fixed Price | **$0.61** total. |
| **3** | Media Mail | Pounds | **$4.47** for the first lb. + **$0.72** for each extra lb. |



## ⚠️ Error Handling

The program has some safety checks built in:

| Problem | What the Code Does |
| :--- | :--- |
| **Invalid option in category (e.g., you type `4`, `-1` or `hello`)** | Prints an error message. |
| **Invalid Weight (e.g., negative number like `-4`, or a decimal like `5.5`)** | Prints an error and stops the calculation. |
| **String Value for Weight (e.g., you type `five` for the weight)** | **The program will crash.** The code is built to expect a number, and as instructed, we have not learnt the code needed to prevent a crash from text input. |



## 📝 How to Run It

1.  **Compile the file:**
    ```
    javac Postage.java
    ```
2.  **Run the program:**
    ```
    java Postage
    ```
3.  **Follow the steps:** Enter the number for your mail type (`1`, `2`, or `3`), then enter the weight as a whole number.
