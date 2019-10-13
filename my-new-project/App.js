import React, { useState } from 'react';
import { StyleSheet, Text, View, TextInput, Button} from 'react-native';

export default function App() {
  return (
    <View style={{padding: 50}}>
      <View style={{flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center'}}>
        <TextInput placeholder="Enter your goal" 
        style={{borderColor: 'black', borderWidth: 1, padding: 10}}
        />
        <Button title="ADD" />
      </View>
      <View>

      </View>
    </View>
  );
} 

const styles = StyleSheet.create({
  
});
