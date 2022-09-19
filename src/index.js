import { useEffect } from "react";

const KeepAwake = require("./NativeKeepAwake").default;

export const activateKeepAwake = () => {
  KeepAwake.activate();
};

export const deactivateKeepAwake = () => {
  KeepAwake.deactivate();
};

export const useKeepAwake = () => {
  useEffect(() => {
    activateKeepAwake();
    return deactivateKeepAwake;
  }, []);
};

export default () => {
  useEffect(() => {
    activateKeepAwake();
    return deactivateKeepAwake;
  }, []);

  return null;
};
