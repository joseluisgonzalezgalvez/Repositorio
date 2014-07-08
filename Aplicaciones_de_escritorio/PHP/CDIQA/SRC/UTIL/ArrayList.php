<?php
 
  class ArrayList {
 
    private $array;
 
    public function ArrayList() {
      $this->array = array();
    }
 
    public function addItem($item){
      $this->array[] = $item ;
    }
 
    public function toString(){
      $cadena = "";
      foreach ($this->array as $item) {
        $cadena .= $item;
      }
      return $cadena;
    }
 
    public function delete($item){
      unset($this->array[$item]);
    }
 
    public function item($item){
      return $this->array[$item];
    }
 
    public function size(){
      $size = 0;
      foreach ($this->array as $item) {
        $size++;
      }
      return $size;
    }
  }
 
?>