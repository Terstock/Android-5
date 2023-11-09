package com.example.fragment_lab_1fr;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class First_fragmentDirections {
  private First_fragmentDirections() {
  }

  @NonNull
  public static ActionFirstFragmentToSecondFragment actionFirstFragmentToSecondFragment(
      @NonNull String namus) {
    return new ActionFirstFragmentToSecondFragment(namus);
  }

  public static class ActionFirstFragmentToSecondFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionFirstFragmentToSecondFragment(@NonNull String namus) {
      if (namus == null) {
        throw new IllegalArgumentException("Argument \"namus\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("namus", namus);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFirstFragmentToSecondFragment setNamus(@NonNull String namus) {
      if (namus == null) {
        throw new IllegalArgumentException("Argument \"namus\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("namus", namus);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("namus")) {
        String namus = (String) arguments.get("namus");
        __result.putString("namus", namus);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_first_fragment_to_second_fragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getNamus() {
      return (String) arguments.get("namus");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionFirstFragmentToSecondFragment that = (ActionFirstFragmentToSecondFragment) object;
      if (arguments.containsKey("namus") != that.arguments.containsKey("namus")) {
        return false;
      }
      if (getNamus() != null ? !getNamus().equals(that.getNamus()) : that.getNamus() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getNamus() != null ? getNamus().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionFirstFragmentToSecondFragment(actionId=" + getActionId() + "){"
          + "namus=" + getNamus()
          + "}";
    }
  }
}
