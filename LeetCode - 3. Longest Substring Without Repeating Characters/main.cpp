#include <iostream>
#include "map"
using namespace std;
    int lengthOfLongestSubstring(string s) {

        map<char,int> characters;
        int max_length = 0;
        int current_length = 0;
        int cursor = 0;
        int current_characters_index_in_map = 0;
        for(int i = 0; i < s.length(); i++){
            current_characters_index_in_map = characters.find(s[i])->second;
            if(characters.find(s[i]) == characters.end()){
                current_length++;
            }
            else if(current_characters_index_in_map >= cursor){
                if(current_length > max_length){
                    max_length = current_length;
                }
                current_length = i - (current_characters_index_in_map);
                cursor = current_characters_index_in_map + 1;
                characters.erase(s[i]);
            }
            else{
                characters.erase(s[i]);
                current_length++;
            }
            characters.insert({s[i],i});
        }
        if(current_length > max_length){
            max_length = current_length;
        }
        return max_length;
    }

int main() {

    //inputs
    string s;
    //algorithm
    int result = lengthOfLongestSubstring(s);
    return 0;
}
