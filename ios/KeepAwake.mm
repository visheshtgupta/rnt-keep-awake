

#import "KeepAwake.h"
#import "UIKit/UIKit.h"


@implementation RTNKeepAwake

RCT_EXPORT_MODULE(RTNKeepAwake);

RCT_EXPORT_METHOD(activate)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[UIApplication sharedApplication] setIdleTimerDisabled:YES];
    });
}

RCT_EXPORT_METHOD(deactivate)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[UIApplication sharedApplication] setIdleTimerDisabled:NO];
    });
}

@end