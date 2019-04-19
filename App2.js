/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  NativeModules,
  Button,
  DeviceEventEmitter
} from 'react-native';


type Props = {};
export default class App extends Component<Props> {


  componentWillMount() {
    //监听事件名为EventName的事件
    DeviceEventEmitter.addListener('EventName', function () {
      alert("Android send js msg success");
    });
  }


  onPress = () => {
    NativeModules.MyNativeModule.rnCallNative('RN与安卓开发').then((msg) => {
      console.log("回执：" + msg);
    });
  }

  render() {
    return (
      <View style={styles.container}>
        <Button onPress={this.onPress} title="toast2"></Button>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
