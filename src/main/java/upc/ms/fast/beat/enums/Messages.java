package upc.ms.fast.beat.enums;

public enum Messages {

	  DELETE {
	      public String toString() {
	          return  "Se eliminó el registro de manera correcta";
	      }
	  },

	  CREATE {
	      public String toString() {
	          return "Se registró el dato de manera correcta";
	      }
	  },

	  EDIT {
	      public String toString() {
	          return "Se editó el registro de manera correcta";
	      }
	  },
	  
	  DISABLED {
	      public String toString() {
	          return "Se desactivo el registro de manera correcta";
	      }
	  },
	  
	  ENABLED {
	      public String toString() {
	          return "Se activo de manera correcta";
	      }
	  }
}
