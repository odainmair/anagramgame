# Anagram Game

 
 The idea of the Anagram game is to collect Anagrams from files uploaded to the main screen of the game.
  the way Anagram Game works:
  1. Open the Anagram Game  
  2. The game accepts two files, the files would contain texts, paragraphs.  
  3. Start teh Game by clicking on the "Start Game" button
  4. the game is meant to compare two files' content and search for Anagrams
  5. when an Anagram is found (by comparing both uploaded files), it would be added to a listview
  6. if the Anagram that is found and added to the list view is of the same word order, then it would be starred.
  7. the game would send a push notification for each found Anagram and the total number of them
  8. After the game finishes the comparison between both files, the game would enable the user to share the found ones via an email with their friends.

To Add files to File Manager in emulator use the following command in terminal
adb push angram1.txt /sdcard/angram1.txt

Features Used in the Game:
1. ViewModel & LiveData
2. Read Text File from File Manager
3. Push Notification 
4. RecycleView with multi type view holder
5. Send Email

 <p align="center"> 
<img src="https://github.com/odainmair/anagramgame/blob/master/Angram.gif" width="320" height="640">
</p>
