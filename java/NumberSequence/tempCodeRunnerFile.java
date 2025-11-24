System.out.print("What's the pattern between each of the numbers (example answer: add 8)? ");
        userPattern = input.next();
        if (!(userPattern.equalsIgnoreCase("+"+changingConstant) || userPattern.equalsIgnoreCase(""+changingConstant)))
        {
            userPattern += " "+input.next();
        }
        if (userPattern.equalsIgnoreCase("increment by") || userPattern.equalsIgnoreCase("decrement by")) 
        {
            userPattern += " "+input.next();
        