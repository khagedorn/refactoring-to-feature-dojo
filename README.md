The PiggyBank Refactoring Kata
==============================

The goal of this Kata is to apply a refactoring technique
called "Refactoring to Feature" (todo: add link) to an
existing legacy code base.

The Scenario
------------

Imagine you are a young kid learning Java and you have
written a small program to keep track of your personal
savings. Recently you learned about TDD and
object-oriented design. Looking back on your PiggyBank
program you realize, that what you have written earlier
might not exactly be "quality code". You wanted to add
some new features anyway, so you decide you should refactor
the code as you implement the features.

The Approach
------------
You read a blog post about a fancy new approach called
"Refactoring to Feature". The idea is that you don't
directly add a new feature to the legacy code base, but
instead you first refactor the code so that your new feature
is really easy to implement. Given as step-by-step
instructions the process goes somewhat like that:

1. Try to write a nice and clean test to motivate your feature
2. Realize why it is hard to do so and which points in your code
   need refactoring
3. Stash/@Ignore/delete your test. Now concentrate on refactoring
   exactly those points, where it is hard to add a feature. Don't
   touch the code that doesn't bother you. Don't forget to refactor
   and reorganize your existing tests as you go or to add new
   tests for existing functionality.
4. When you think you are done unstash/unignore/rewrite the test.
   When you are lucky, the new feature is added in a few minutes and
   everything falls nicely into place, if not, repeat the process.

The Program
-----------
The PiggyBank currently supports saving, withdrawing and getting
the amount currently in the bank. All of the savings and withdrawals
are stored in a text file. The Application is started using the main
method in the PiggyBankClient class. You can try the following commands:
 * save 10.00
 * withdraw 8.30
 * balance

There are some tests in place, but maybe you shouldn't trust them too
much :)

The Features
------------
These are the features you want to add:

* Rob the bank: You want to empty your piggybank, so when you enter
  'rob', the bank should be empty
* Help: You now have so many commands that you can't remember
  all of them so when you enter 'help' or an illegal command, you want
  to see an overview of all possible commands with a short explanation,
  somewhat like "save <amount>	Stores the given amount to the piggybank ..."
* History: You want to see the last five transactions on your piggy bank,
  so when you press [h] (for history) you want to see something like
  '01.01.2013, 11:11: Saved 90.00
   01.02.2013, 14:13: Withdrawed: 30.00'
* Savings per month: you want to see how much money you saved or
  withdrawed in average over the last three months, e.g. you added
  150.00 and withdrawed 90.00 in the last three months and you
  pressed the [t] button, you want to see an output like
  'Trend: +20.00 per Month'
* Saving Goals: Given how much you spent and withdrawed over the last
  three month, you want to know how long it would take you to buy
  something, so if you have 150.00 in the bank, you save 20.00
  per month and you press [g], [200][return], you want to see
  an output like 'It will take you 2.5 months until you have 200.00'

Discussion
----------
Here are some questions that you might ask yourself, or ask the group
as a facilitator in a dojo:

 * How did you like the approach?
 * Did it work? Was the feature easy to add in the end?
 * Compared to 'classic' refactoring approaches, such as the "big
   complete system refactoring that never happens" or the "boyscout
   rule" approaches, how much effort did you have to invest in 
   refactoring? How much better or worse is the resulting code?
 * Which refactorings were your first steps?
 * Did you refactor the test? How much new tests did you add?
 * Which parts were 'smelly' but weren't refactored? Why?
 * Did you decide to change any behavior?
 